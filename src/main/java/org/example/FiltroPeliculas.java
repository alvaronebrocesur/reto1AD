package org.example;

import java.io.*;

public class FiltroPeliculas {
    /* Este metodo coge del archivo que esta en la raiz "peliculas.csv" y analiza el año en el
    * que fueron hechas a partir del parametro "n" y crea un archivo "PelicualsPosterioresA'n'.csv"
    * donde guarda las peliculas que cumplan el filtro
    * @param n año por el cual se filtran las pliculas
    */
    public void filtrarPorAno(Integer n) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("peliculas.csv"));
            String linea;
            String[] aux;
            BufferedWriter bw = new BufferedWriter(new FileWriter("PeliculasPosterioresA"+n+".csv"));
            while ((linea = br.readLine()) != null) {
                aux = linea.split(",");
                if (Integer.parseInt(aux[2]) > n) bw.write(linea+"\n");
            }
            br.close();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
