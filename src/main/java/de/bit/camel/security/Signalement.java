package de.bit.camel.security;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Rami TORKHANI
 */
@XmlRootElement
public class Signalement {
    private String sigId ;
    private String reporter = "";
    private String importance = "";
    private String lieu = "";
    private String description = "";
    private String dateDemande = "";
    private String state = "";


    public String getSigId() {
		return sigId;
	}


	public String getReporter() {
		return reporter;
	}


	public String getImportance() {
		return importance;
	}


	public String getLieu() {
		return lieu;
	}


	public String getDescription() {
		return description;
	}


	public String getDateDemande() {
		return dateDemande;
	}


	public String getSolved() {
		return state;
	}


	public void setSigId(String sigId) {
		this.sigId = sigId;
	}


	public void setReporter(String reporter) {
		this.reporter = reporter;
	}


	public void setImportance(String importance) {
		this.importance = importance;
	}


	public void setLieu(String lieu) {
		this.lieu = lieu;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setDateDemande(String dateDemande) {
		this.dateDemande = dateDemande;
	}


	public void setSolved(String solved) {
		this.state = solved;
	}


	@Override
    public String toString() {
        StringBuilder emp = new StringBuilder();
        emp.append("sigId ").append(sigId).append(", ");
        emp.append("reporter ").append(reporter).append(", ");
        emp.append("importance ").append(importance).append(", ");
        emp.append("lieu ").append(lieu).append(", ");
        emp.append("description ").append(description).append(", ");
        emp.append("dateDemande ").append(dateDemande).append(", ");
        emp.append("state ").append(state);
        return emp.toString();
    }
}
