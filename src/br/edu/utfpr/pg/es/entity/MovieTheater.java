package br.edu.utfpr.pg.es.entity;


/**
 * @author Vinicius
 * @UTFPR
 */

public class MovieTheater {

    private Integer number;
    private Integer capacity;

    public MovieTheater(Integer number, Integer capacity) {
    
        this.number = number;
        this.capacity = capacity;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
