/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author User_1
 */
public class Athlete {
    private int intCode;
    private String strName;
    private String strLastName;
    private double dblSalary;
    private String strMedal;
    private String strDate;
    private int intQuantity;
    private String strSportType;

    public Athlete(
        int intCode,
        String strName,
        String strLastName,
        double dblSalary, 
        String strMedal,
        String strDate,
        int intQuantity,
        String strSportType
    ) {
        this.intCode = intCode;
        this.strName = strName;
        this.strLastName = strLastName;
        this.dblSalary = dblSalary;
        this.strMedal = strMedal;
        this.strDate = strDate;
        this.intQuantity = intQuantity;
        this.strSportType = strSportType;
    }

    public int getIntCode() {
        return intCode;
    }

    public void setIntCode(int intCode) {
        this.intCode = intCode;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrLastName() {
        return strLastName;
    }

    public void setStrLastName(String strLastName) {
        this.strLastName = strLastName;
    }
    
    public double getDblSalary() {
        return dblSalary;
    }

    public void setDblSalary(double dblSalary) {
        this.dblSalary = dblSalary;
    }

    public String getStrMedal() {
        return strMedal;
    }

    public void setStrMedal(String strMedal) {
        this.strMedal = strMedal;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public int getIntQuantity() {
        return intQuantity;
    }

    public void setIntQuantity(int intQuantity) {
        this.intQuantity = intQuantity;
    }

    public String getStrSportType() {
        return strSportType;
    }

    public void setStrSportType(String strSportType) {
        this.strSportType = strSportType;
    }
    
    
    @Override
    public String toString() {
        return "Deportista {" + "codigo: " + intCode + ", Nombre: " + strName + " " + strLastName + ", Salario: " + dblSalary + ", Medalla: { Tipo: " + strMedal + " Fecha: "+ strDate +" }, Cantidad: " + intQuantity + ", Tipo deporte: " + strSportType + '}';
    }
}
