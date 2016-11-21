package de.bit.camel.security;

import javax.xml.bind.annotation.XmlRootElement;

	@XmlRootElement
	public class OrdreDeMission {
	    private String traitId = "";
	    private String sig_sig_id = "";
	    private String agent = "";
	    private String intervenant = "";
	    private String dateIntervention = "";
	    private String detailIntervention = "";
	    private String valid ="";


		public String getSigId() {
			return sig_sig_id;
		}
		public void setSigId(String sigId) {
			this.sig_sig_id = sigId;
		}
		public String getValid() {
			return valid;
		}
		public void setValid(String valid) {
			this.valid = valid;
		}
		public void setTraitId(String traitId) {
			this.traitId = traitId;
		}
		public void setAgent(String agent) {
			this.agent = agent;
		}
		public void setIntervenant(String intervenant) {
			this.intervenant = intervenant;
		}
		public void setDateIntervention(String dateIntervention) {
			this.dateIntervention = dateIntervention;
		}
		public String getTraitId() {
			return traitId;
		}
		public String getAgent() {
			return agent;
		}
		public String getIntervenant() {
			return intervenant;
		}
		public String getDateIntervention() {
			return dateIntervention;
		}
		public String getDetailIntervention() {
			return detailIntervention;
		}
		public void setDetailIntervention(String detailIntervention) {
			this.detailIntervention = detailIntervention;
		}
		@Override
	    public String toString() {
	        StringBuilder ms = new StringBuilder();
	        ms.append("traitId ").append(traitId).append(", ");
	        ms.append("sig_sig_id ").append(sig_sig_id).append(", ");
	        ms.append("agent ").append(agent).append(", ");
	        ms.append("intervenant ").append(intervenant).append(", ");
	        ms.append("dateIntervention ").append(dateIntervention).append(", ");
	        ms.append("detailIntervention ").append(detailIntervention).append(", ");
	        ms.append("valid ").append(valid).append(", ");

	        return ms.toString();
	    }

}
