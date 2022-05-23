/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Datos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author IFRODRIGUERO
 */
public class Controller {

    public static void inicio() {
         Scanner sc = new Scanner(System.in);
         List<Datos> list=llenarList();
        System.out.println("Elija la opcion:");
        System.out.println("1. Cuantas veces fue campeon");
        System.out.println("2. países han ganado la Copa Mundial de fútbol a partir de un año especifico");
        System.out.println("3. selecciones han llegado más veces a una final de un mundial de fútbol");
        System.out.println("4. Listado de países con más mundiales ganados");
        System.out.println("5. Países sede que han tenido más mundiales. ");
        int op = sc.nextInt();
        if (op ==1){
             System.out.println("Escriba el Pais:");
         String pais = sc.next();
         buscarGanador(list, pais);
        }else if(op==2){
            System.out.println("Escriba año:");
        String año = sc.next();
        listaDeGanadores(list, año);
        }else if(op==3){
            finalMundo(list);
        }else if(op==4){
            ganadoresMundo(list);
        }else if(op==5){
            paisesSede(list);
        }

    }
    
    public static  void buscarGanador(List<Datos> list, String nombre){
     List<String> listgan = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getCampeon().equalsIgnoreCase(nombre)){
            listgan.add(list.get(i).getAño());
            }
        }
        
        for (int i = 0; i < listgan.size(); i++) {
             System.out.println(listgan.get(i)+"\n");
        }
    }
    
    public static void listaDeGanadores (List<Datos> list, String año){
    
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAño().equalsIgnoreCase(año)){
                for (int j = i; j < list.size(); j++) {
                    System.out.println(list.get(j).getAño()+"  : "+list.get(j).getCampeon()+"\n");
                }
                return;
            } 
        }
         System.out.println("El año ingresado no se encuentra en la lista");
    }
    
    public static void finalMundo(List<Datos> list) {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        List<String> list1 = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            list1.add(list.get(i).getCampeon());
            list1.add(list.get(i).getSubcampeon());
        }
        for (String i : list1) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }
        List<Entry<String, Integer>> lista = new ArrayList<>(hm.entrySet());
        	lista.sort(Entry.comparingByValue());
		lista.forEach(System.out::println);
       
    }
    
        public static void ganadoresMundo(List<Datos> list) {
         Map<String, Integer> hm = new HashMap<String, Integer>();
        List<String> list1 = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            list1.add(list.get(i).getCampeon());
        }
        for (String i : list1) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }
        List<Entry<String, Integer>> lista = new ArrayList<>(hm.entrySet());
        	lista.sort(Entry.comparingByValue());
		lista.forEach(System.out::println);
    }
        
            public static void paisesSede(List<Datos> list) {
         Map<String, Integer> hm = new HashMap<String, Integer>();
        List<String> list1 = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            list1.add(list.get(i).getSede());
        }
        for (String i : list1) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }
        List<Entry<String, Integer>> lista = new ArrayList<>(hm.entrySet());
        	lista.sort(Entry.comparingByValue());
		lista.forEach(System.out::println);
    }
    

    public static List<Datos> llenarList() {
        List<Datos> list = new ArrayList<Datos>();
        String file = "C:/Users/ProjectSupport/Documents/NetBeansProjects/Ejercicio3/src/Datos/tabla.txt";
        try ( BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] textElements = line.split(",");
                Datos dato = new Datos();
                dato.setAño(textElements[0]);
                dato.setCampeon(textElements[1]);
                dato.setSede(textElements[3]);
                dato.setSubcampeon(textElements[2]);
                list.add(dato);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }

}
