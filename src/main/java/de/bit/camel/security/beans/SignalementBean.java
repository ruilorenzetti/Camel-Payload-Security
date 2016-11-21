package de.bit.camel.security.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import de.bit.camel.security.Signalement;


/**
 * 
 * @author Rami TORKHANI
 */
public class SignalementBean {
    private Logger logger = Logger.getLogger(SignalementBean.class);

    private SimpleJdbcTemplate simpleJdbcTemplate;
    private static final String QUERY_FOR_SIG = "select importance, reporter,lieu, description, dateDemande from signalement where sig_id = ?";

    public Signalement getSignalementData(final String sigId) {
        try {
        	Signalement sig = simpleJdbcTemplate.queryForObject(QUERY_FOR_SIG, new RowMapper<Signalement>() {
                @Override
                public Signalement mapRow(ResultSet rs, int rowNum) throws SQLException {
                	Signalement sig = new Signalement();
                	sig.setSigId(sigId);
                	sig.setReporter(rs.getString("reporter"));
                	sig.setImportance(rs.getString("importance"));
                	sig.setLieu(rs.getString("lieu"));
                	sig.setDescription(rs.getString("description"));
                	sig.setDateDemande(rs.getString("dateDemande"));
                    return sig;
                }

            }, new Object[] {sigId});

            logger.info("getSignalementData for signalement id " + sigId + " returned " + sig.toString());

            return sig;
        } catch (EmptyResultDataAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public boolean isSolved(Signalement signal) {
        return signal.getSolved().equals("SOLVED");
    }

    @Required
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }
}
