/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

/**
 *
 * @author Admin
 */
public class Fecha {

    private int dia;
    private int mes;
    private int year;

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

}
