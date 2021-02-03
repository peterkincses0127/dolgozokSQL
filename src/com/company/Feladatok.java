package com.company;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Feladatok {
    ArrayList<Dolgozo> dolgozoLista;
    public Feladatok(){
        dolgozoLista = Beolvas("select * from dolgozok");
        int menupont = 0;
        System.out.println("Válasszon a menüpontok között:\n\t1. Összes dolgózó adata\n\t2. Beszúrni egy új dolgozót\n\t3. Keresni egy dolgozót");
        Scanner sc = new Scanner(System.in);
        menupont = sc.nextInt();
        switch (menupont){
            case 1 :
                for (Dolgozo d:dolgozoLista
                     ) {
                    System.out.println(d);
                }break;
            case 2 :


        }
        System.out.println(dolgozoLista.get(0));
    }

    private ArrayList<Dolgozo> Beolvas(String kapcs) {
        ArrayList<Dolgozo> dolgozok = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost:3306/dolgozok";
            String user = "root";
            String password = "";
            Connection kapcsolat = DriverManager.getConnection(url,user,password);
            Statement allapot = kapcsolat.createStatement();
            ResultSet rs = allapot.executeQuery(kapcs);
            System.out.println("Sikeres kapcsolat");
            while(rs.next()){
                String nev=rs.getString(2);
                String nem = rs.getString(3);
                int kor = rs.getInt(4);
                int fizetes = rs.getInt(5);
                Dolgozo obj = new Dolgozo(nev,nem,kor,fizetes);
                dolgozok.add(obj);

            }
            kapcsolat.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return dolgozok;
    }
    private void Bevitel(){
        try {
            String url = "jdbc:mysql://localhost:3306/dolgozok";
            String user = "root";
            String password = "";
            Connection kapcsolat = DriverManager.getConnection(url,user,password);
            PreparedStatement st = kapcsolat.prepareStatement("INSERT INTO DOLGOZOK(ID, NEV,KOR,FIZETES)")
        }catch (SQLException ex){

        }
    }
}
