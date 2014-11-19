package dam.pmdm.llistes;

public class Element {
	private int idImatge;
	private String textSuperior;
	private String textInferior;

	public Element(int idIm, String txt1, String txt2) {
		this.idImatge = idIm;
		this.textSuperior = txt1;
		this.textInferior = txt2;
	}

	public String getTextSuperior() {
		return textSuperior;
	}

	public String getTextInferior() {
		return textInferior;
	}

	public int getIdImatge() {
		return idImatge;
	}

}
