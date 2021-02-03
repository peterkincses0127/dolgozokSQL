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
            case 2 : Bevitel();


        }

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
            PreparedStatement st = kapcsolat.prepareStatement("INSERT INTO `dolgozok`(`id`, `nev`, `nem`, `kor`, `fizetes`) VALUES  (?,?,?,?,?)");
            String nev = "";
            String nem = "";
            int kor = 0;
            int fizetes = 0;
            Scanner sc = new Scanner(System.in);
            System.out.print("Név: ");
            nev = sc.nextLine();
            System.out.print("Nem: ");
            nem = sc.nextLine();
            System.out.print("Kor: ");
            kor = sc.nextInt();
            System.out.print("Fizetés: ");
            fizetes = sc.nextInt();

            st.setString(2,nev);
            st.setString(3,nem);
            st.setInt(4,kor);
            st.setInt(5,fizetes);
            st.execute();
        }catch (SQLException ex){
            ex.getMessage();
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
