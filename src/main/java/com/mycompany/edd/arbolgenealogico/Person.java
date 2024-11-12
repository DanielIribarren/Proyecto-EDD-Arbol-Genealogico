package com.mycompany.edd.arbolgenealogico;

public class Person {

    private String Numeral;
    private String Padre;
    private String Mote;
    private String Esposa;
    private String ColorEyes;
    private String ColorHair;
    private SimpleList <Person> FatherTo;
    private String Notes;
    private String Fate;

    public Person(String Numeral, String Padre, String Mote, String Esposa, String ColorEyes, String ColorHair, String Notes, String Fate) {
        this.Numeral = Numeral;
        this.Padre = Padre;
        this.Mote = Mote;
        this.Esposa = Esposa;
        this.ColorEyes = ColorEyes;
        this.ColorHair = ColorHair;
        this.FatherTo = new SimpleList<Person>();
        this.Notes = Notes;
        this.Fate = Fate;
    }
    
    

    /**
     * @return the Numeral
     */
    public String getNumeral() {
        return Numeral;
    }

    /**
     * @param Numeral the Numeral to set
     */
    public void setNumeral(String Numeral) {
        this.Numeral = Numeral;
    }

    /**
     * @return the Padre
     */
    public String getPadre() {
        return Padre;
    }

    /**
     * @param Padre the Padre to set
     */
    public void setPadre(String Padre) {
        this.Padre = Padre;
    }

    /**
     * @return the Mote
     */
    public String getMote() {
        return Mote;
    }

    /**
     * @param Mote the Mote to set
     */
    public void setMote(String Mote) {
        this.Mote = Mote;
    }

    /**
     * @return the Esposa
     */
    public String getEsposa() {
        return Esposa;
    }

    /**
     * @param Esposa the Esposa to set
     */
    public void setEsposa(String Esposa) {
        this.Esposa = Esposa;
    }

    /**
     * @return the ColorEyes
     */
    public String getColorEyes() {
        return ColorEyes;
    }

    /**
     * @param ColorEyes the ColorEyes to set
     */
    public void setColorEyes(String ColorEyes) {
        this.ColorEyes = ColorEyes;
    }

    /**
     * @return the ColorHair
     */
    public String getColorHair() {
        return ColorHair;
    }

    /**
     * @param ColorHair the ColorHair to set
     */
    public void setColorHair(String ColorHair) {
        this.ColorHair = ColorHair;
    }
    
    



}
