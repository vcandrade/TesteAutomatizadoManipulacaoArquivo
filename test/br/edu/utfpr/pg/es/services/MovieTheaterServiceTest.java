/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pg.es.services;

import br.edu.utfpr.pg.es.entity.MovieTheater;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vcandrade
 */
public class MovieTheaterServiceTest {

    private MovieTheaterService movieTheaterService;

    public MovieTheaterServiceTest() {

    }

    @Before
    public void setUp() {

        // ============= MONTAGEM DO CENÁRIO ============== //
        this.movieTheaterService = new MovieTheaterService();
        this.movieTheaterService.createFile("Data Base.txt");
    }

    @After
    public void tearDown() {

        this.movieTheaterService.deleteFile("Data Base.txt");
        this.movieTheaterService = null;
    }

    @Test
    public void createFileTest() {
        
        // =================== EXECUÇÃO =================== //
        this.movieTheaterService.deleteFile("Data Base.txt");
        boolean verification = this.movieTheaterService.createFile("Data Base.txt");
        
        // ================== VERIFICAÇÃO ================= //
        assertTrue(verification);
    }
    
    @Test
    public void writeTest() {
        
        // ============= MONTAGEM DO CENÁRIO ============== //
        MovieTheater movieTheater1 = new MovieTheater(1, 50);
        MovieTheater movieTheater2 = new MovieTheater(2, 60);
        MovieTheater movieTheater3 = new MovieTheater(3, 70);
        MovieTheater movieTheater4 = new MovieTheater(4, 80);
        
        // =================== EXECUÇÃO =================== //        
        boolean verification1 = movieTheaterService.write("Data Base.txt", movieTheater1);
        boolean verification2 = movieTheaterService.write("Data Base.txt", movieTheater2);
        boolean verification3 = movieTheaterService.write("Data Base.txt", movieTheater3);
        boolean verification4 = movieTheaterService.write("Data Base.txt", movieTheater4);
        
        // ================== VERIFICAÇÃO ================= //
        assertTrue(verification1);
        assertTrue(verification2);
        assertTrue(verification3);
        assertTrue(verification4);
    }
    
    @Test
    public void editTest() {

        // ============= MONTAGEM DO CENÁRIO ============== //
        MovieTheater movieTheater1 = new MovieTheater(1, 50);
        MovieTheater movieTheater2 = new MovieTheater(2, 60);
        MovieTheater movieTheater3 = new MovieTheater(3, 70);
        MovieTheater movieTheater4 = new MovieTheater(4, 80);
        
        MovieTheater oldMovieTheater = new MovieTheater(3, 70);
        MovieTheater newMovieTheater = new MovieTheater(7, 140);

        // =================== EXECUÇÃO =================== //    
        this.movieTheaterService.write("Data Base.txt", movieTheater1);
        this.movieTheaterService.write("Data Base.txt", movieTheater2);
        this.movieTheaterService.write("Data Base.txt", movieTheater3);
        this.movieTheaterService.write("Data Base.txt", movieTheater4);
        
        boolean verification = movieTheaterService.edit("Data Base.txt", oldMovieTheater, newMovieTheater);

        // ================= VERIFICAÇÃO ================== //
        assertTrue(verification);
    }
}
