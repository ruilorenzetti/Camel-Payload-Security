package de.bit.camel.security.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import de.bit.camel.security.OrdreDeMission;


/**
 * 
 * @author Rami TORKHANI
 */
public class OrdreDeMissionBean {
    private Logger logger = Logger.getLogger(OrdreDeMissionBean.class);

    private SimpleJdbcTemplate simpleJdbcTemplate;
    private static final String QUERY_FOR_SIG = "select * from ordremission where sig_sig_id = ?";

    public OrdreDeMission getOrdreDeMissionData(final String sigId) {
        try {
        	OrdreDeMission mission = simpleJdbcTemplate.queryForObject(QUERY_FOR_SIG, new RowMapper<OrdreDeMission>() {
                @Override
                public OrdreDeMission mapRow(ResultSet rs, int rowNum) throws SQLException {
                	OrdreDeMission ms = new OrdreDeMission();
                	ms.setTraitId(rs.getString("traitId"));
                	ms.setSigId(sigId);
                	ms.setAgent(rs.getString("agent"));
                	ms.setIntervenant(rs.getString("intervenant"));
                	ms.setDateIntervention(rs.getString("dateIntervention"));
                	ms.setDetailIntervention(rs.getString("detailIntervention"));

                    return ms;
                }

            }, new Object[] {sigId});

            logger.info("getSignalementData for signalement id " + sigId + " returned " + mission.toString());

            return mission;
        } catch (EmptyResultDataAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
    


    @Required
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }
}
