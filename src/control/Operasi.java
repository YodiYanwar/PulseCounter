/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.text.NumberFormat;

/**
 *
 * @author YODIEYS
 */
public class Operasi {
    NumberFormat nf = NumberFormat.getInstance();

    private int saldoA;
    private int saldoB;
    private int omset;
    private int laba;
    private int pemakaian;
    
    
    public void setSaldoA(int a){
        this.saldoA = a;
    }
    public String getSaldoA(){
        return nf.format(saldoA);
    }
    
    public void setSaldoB(int b){
        this.saldoB = b;
    }
    public String getSaldoB(){
        return nf.format(saldoB);
    }
    
    public void setOmset(int o){
        this.omset = o;
    }
    public String getOmset(){
        return nf.format(omset);
    }
    
    public String pemakaian(){     
        pemakaian = saldoA-saldoB;
        return nf.format(pemakaian);
    }
    
    public String laba(){               
        laba = omset-(saldoA-saldoB);
        return nf.format(laba);
    }
}
