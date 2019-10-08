
package br.edu.utfpr.pg.es.services;

import br.edu.utfpr.pg.es.entity.MovieTheater;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Vinicius
 * @UTFPR
 */

public class MovieTheaterService {
    
    private ArrayList<MovieTheater> cinema;

    public MovieTheaterService() {

        this.cinema = new ArrayList<>();
    }

    public boolean createFile(String fileName) {

        try {

            File file = new File(fileName);
            file.createNewFile();

            return true;

        } catch (IOException ex) {

            System.out.println("error: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean deleteFile(String fileName) {

        File file = new File(fileName);
        file.delete();
        
        return true;
    }

    public boolean write(String fileName, MovieTheater movieTheater) {

        try {

            FileWriter file = new FileWriter(fileName, true);
            BufferedWriter doc = new BufferedWriter(file);

            doc.write(movieTheater.getNumber() + "#" + movieTheater.getCapacity());
            doc.newLine();

            doc.close();

            System.out.println("Movie theater successfully added.");
            return true;

        } catch (IOException ex) {

            System.out.println("error: " + ex.getMessage());
            return false;
        }
    }

    public boolean edit(String fileName, MovieTheater oldMovieTheater, MovieTheater newMovieTheater) {

        try {

            // cria-se um arquivo temporário
            String temporaryFile = "temporary file.txt";
            this.createFile(temporaryFile);
            BufferedWriter temporaryDoc = new BufferedWriter(new FileWriter(temporaryFile));

            // abre o arquivo principal para encontrar o registro que se deseja editar
            BufferedReader doc = new BufferedReader(new FileReader(fileName));
            String movieTheater = doc.readLine();

            while (movieTheater != null) {

                // após fazer a leitura da linha do arquivo principal, separa-se o que é número do que é capacidade
                String[] movieTheaterData = movieTheater.split("#");
                int number = (Integer.parseInt(movieTheaterData[0]));
                int capacity = (Integer.parseInt(movieTheaterData[1]));

                // se o número da sala que está querendo editar for igual ao número da sala que se fez a leitura do txt, então escreve no arquivo temporário os novos dados
                if (oldMovieTheater.getNumber() == number) {

                    temporaryDoc.write(newMovieTheater.getNumber() + "#" + newMovieTheater.getCapacity());

                // caso contrário, apenas copia-se o que estava no arquivo principal para o arquivo temporário
                } else {

                    temporaryDoc.write(number + "#" + capacity);
                }
                
                // cria-se mais uma linha para escrever no arquivo temporário e faz uma nova leitura no arquivo principal
                temporaryDoc.newLine();
                movieTheater = doc.readLine();
            }

            // fecha o arquivo principal e o arquivo temporário
            doc.close();
            temporaryDoc.close();
            
            // deleta-se o arquivo principal, pois o mesmo está desatualizado
            File oldFile = new File(fileName);
            oldFile.delete();
            
            // renomeia o arquivo temporário com o nome do principal
            File newFile = new File(temporaryFile);
            newFile.renameTo(new File(fileName));
            
            System.out.println("Movie Theater successfully edited.");
            
            return true;

        } catch (Exception ex) {

            System.out.println("error: " + ex.getMessage());
            return false;
        }
    }
}
