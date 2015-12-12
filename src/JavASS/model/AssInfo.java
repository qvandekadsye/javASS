package JavASS.model;

public class AssInfo {
	String titre = "";
	String originalScript ="";
	String traduction="";
	String edition="";
	String timing="";
	String Synch="";
	String updatedBy="";
	String updateDetails="";
	String YCbCr="";
	int resX=0;
	int resY=0;
	int wrapStyle=0;
	boolean scale;

	/**
	 * Defaut constructeur
	 */
	public AssInfo()
	{

	}

	public AssInfo(String title,String oScript, String trad,String edit, String time, String sync, String lastUpdate, String details,String YCbCr)
	{
		this.titre=title;
		this.originalScript=oScript;
		this.traduction=trad;
		this.edition=edit;
		this.timing = time;
		this.Synch=sync;
		this.updatedBy = lastUpdate;
		this.updateDetails = details;
		this.YCbCr = YCbCr;
	}

	public AssInfo(int x, int y, int wrapStyle)
	{
		this.resX=x;
		this.resY = y;
		this.wrapStyle=wrapStyle;
	}

	public AssInfo(String title,String oScript, String trad,String edit, String time, String sync, String lastUpdate, String details,String YCbCr,int x, int y, int wrapStyle)
	{
		this(title, oScript,  trad, edit, time,  sync,  lastUpdate,  details, YCbCr);
		this.resX=x;
		this.resY = y;
		this.wrapStyle=wrapStyle;
	}

	public String getTitre() {
		return titre;
	}

	public String getOriginalScript() {
		return originalScript;
	}

	public String getTraduction() {
		return traduction;
	}

	public String getEdition() {
		return edition;
	}

	public String getTiming() {
		return timing;
	}

	public String getSynch() {
		return Synch;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public String getUpdateDetails() {
		return updateDetails;
	}

	public String getYCbCr() {
		return YCbCr;
	}

	public int getResX() {
		return resX;
	}

	public int getResY() {
		return resY;
	}

	public int getWrapStyle() {
		return wrapStyle;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setOriginalScript(String originalScript) {
		this.originalScript = originalScript;
	}

	public void setTraduction(String traduction) {
		this.traduction = traduction;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public void setSynch(String synch) {
		Synch = synch;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setUpdateDetails(String updateDetails) {
		this.updateDetails = updateDetails;
	}

	public void setYCbCr(String yCbCr) {
		YCbCr = yCbCr;
	}

	public void setResX(int resX) {
		this.resX = resX;
	}

	public void setResY(int resY) {
		this.resY = resY;
	}

	public void setWrapStyle(int wrapStyle) {
		this.wrapStyle = wrapStyle;
	}

	public boolean getScale()
	{
		return this.scale;
	}

	public void setScale(boolean scale)
	{
		this.scale=scale;
	}

}
