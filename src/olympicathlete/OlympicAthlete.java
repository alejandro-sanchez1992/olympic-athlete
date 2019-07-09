/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olympicathlete;

import entity.Athlete;
import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import utilities.DoublyLinkedList;
import utilities.Queue;

/**
 *
 * @author User_1
 */
public class OlympicAthlete {
    
   public static int Menu()
   {
       int op;
       op=Integer.parseInt(JOptionPane.showInputDialog("Digite opcion"
               + "\n 1. Leer Documento de texto"
               + "\n 2. Mostrar Lista Original"
               + "\n 3. Ordenar Deportista por Medallas de oro"
               + "\n 4. Deportistas con más medallas de Oro"
               + "\n 5. Buscar Entre dos valores"
               + "\n 6. Ordenar Intercalando deporte"
               + "\n 7. Salir"));
       return op;
   }
   
    public static ArrayList<String[]> readFile(String filename) throws IOException
    {
        String[] personData = null;
        File file = new File(filename); // example, data.txt
        Scanner input = null;
        ArrayList<String[]> arrayData = new ArrayList<>();
        
        try {
            input = new Scanner(file);
            
            while (input.hasNext()) {
                String data = input.nextLine(); 
                personData = data.split(";");
                arrayData.add(personData);
            }

            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(input != null){
                input.close();
            }
        }
        return arrayData;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        DoublyLinkedList list = new DoublyLinkedList();
        DoublyLinkedList medalList = new DoublyLinkedList();

        Athlete athl = null;
        int op;
        
        do{
            op = Menu();
            switch(op)
            {
                case 1:
                    ArrayList<String[]> data;
                    ArrayList<String[]> medalData;
                    data = readFile("src/utilities/readAthlete.txt");
                    medalData = readFile("src/utilities/readMedal.txt");
                    
                    if (data != null) {
                        for(int i = 0; i < data.size(); i++){
                            athl = new Athlete(Integer.parseInt(data.get(i)[0]), data.get(i)[1], data.get(i)[2], Integer.parseInt(data.get(i)[3]), data.get(i)[4], data.get(i)[6], Integer.parseInt(data.get(i)[5]), data.get(i)[7]);
                            list.pushEnd(athl);
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Lista cargada correctamente");
                    break;

                case 2:                   
                    JOptionPane.showMessageDialog(null, "La lista es: \n" + list.toString() );
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, list.getByMedal());
                    break;
                
                case 4:
                    JOptionPane.showMessageDialog(null, list.getListByUser());
                    break;
                
                case 5:
                    int value1 = Integer.parseInt(JOptionPane.showInputDialog("Digite primer valor"));
                    int value2 = Integer.parseInt(JOptionPane.showInputDialog("Digite segundo valor"));
                    Queue myQueue = new Queue(15);
                    myQueue.push(list.seachBetweenValues(value1, value2));
                    JOptionPane.showMessageDialog(null, "La cola es: \n" + myQueue.pop());
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "La lista es: \n" + list.orderListBySport());
                    break;
                    
                case 7:
                    JOptionPane.showMessageDialog(null, "Finalizando....");
                    break;                    

                default:

                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                    break;

            }

        }while(op!=7);
    }
    
}
