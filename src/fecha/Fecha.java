/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;
// haciendo pruebas de cdmabios//
/**
 *
 * @author Admin
 */
public class Fecha {

    private int dia;
    private int mes;
    private int year;

    private static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    public int bisiesto() {
        int dias = 28;

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            dias = 29;
        }

        return dias;
    }

    public int bisiesto(int a) {
        int dias = 28;

        if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0)) {
            dias = 29;
        }

        return dias;
    }
    
     public int bisiestoDias() {
        int dias = 365;

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            dias = 366;
        }

        return dias;
    }

    public int bisiestoDias(int a) {
        int dias = 365;

        if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0)) {
            dias = 366;
        }

        return dias;
    }

    public boolean comprobarFecha(int d, int m, int y) {

        boolean resultado = true;
        int[] diaMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (y < 0) {
            resultado = false;
        } else {
            diaMes[1] = bisiesto(y);
            if (m < 1 || m > 12) {
                resultado = false;
            } else {
                if (d < 1 || d > diaMes[m - 1]) {
                    resultado = false;
                }
            }
        }
        return resultado;
    }

    public int clacularNumeroOrden() {
        int orden = 0;
        int[] diaMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int m = 0; m < mes - 1; m++) {
            orden = orden + diaMes[m];
        }
        orden = orden + dia;
        return orden;
    }

    public int compararFechas(Fecha fecha) {

        int resultado;
        if (year < fecha.getYear()) {
            resultado = 1;
        } else if (year > fecha.getYear()) {
            resultado = 2;
        } else if (mes < fecha.getMes()) {
            resultado = 1;
        } else if (mes > fecha.getMes()) {
            resultado = 2;
        } else if (dia < fecha.getDia()) {
            resultado = 1;
        } else if (dia > fecha.getDia()) {
            resultado = 2;
        } else {
            resultado = 0;
        }

        return resultado;

    }

    /**
     * metodo que calcula los dias que han pasado del año hasta la fecha que
     * introducimos
     *
     * @return los dias del año que han pasado hasta la fecha
     */
    public int diaspasanAno() {//metodo diaspasanAno
        int diasHastaFecha = 0;//vble para acumular los dias que han pasado
        int mes;//vble para ir recorriendo los meses
        diasMes[1] = bisiesto(year);//compruebo si el año es bisiesto 
        for (mes = 1; mes < this.mes; mes++)//bucle que recorre el vector diasMes
        {//inicio for
            //acumulo los dias del mes hasta que llege al introducido
            diasHastaFecha = diasHastaFecha + diasMes[mes - 1];
        }//fin for
        diasHastaFecha = diasHastaFecha + dia;//acumulo los dias del mes no completo
        return diasHastaFecha;
    }//fin metodo diaspasanAnno

    public int distanciaFechas(Fecha fecha2) {
        int dias=0, m, y;

        if (year == fecha2.getYear()) {
            if (mes == fecha2.getMes()) {
                dias = fecha2.getDia() - dia;
            } else {
                dias = diasMes[mes - 1] - dia;
                m = mes;

                while (m < fecha2.getMes() - 1) {
                    dias = dias + diasMes[m];
                    m++;
                }
                dias=dias+fecha2.getDia();
                /*el while en formato for
                for(m=mes, m<fecha2.getMes()-1)
                { dias=dias+diasMes[m], m++)
                }
                */
            }
                    
            }
        else{
            y=year;
           
            while (y <fecha2.getYear())
            {
             
            }

        }
        return dias;
    }
}