/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataminingdatasetmining;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jay Kumarr
 */
public class DMEffiencient {

    
     public static void main(String arg[]) throws IOException {
        File file = new File("D:\\Study and Documents\\MPhil\\Slides-Lecture\\DM\\$dataset\\paper_author_dataset.csv");
        File outputFile = new File("paper_author_dataset_processed_duplicatefree(new).csv");
        PrintStream out = new PrintStream(new FileOutputStream(outputFile));
        DataInputStream dos = new DataInputStream(new FileInputStream(file));
        String str = null;
        int records = 1;
        int total= 453745;
        String paperId = "";
        StringBuilder  builder = new StringBuilder("AAAA");
        Set<String> authorSet = new HashSet<>();
        while( (str = dos.readLine()) != null){
           String[] strArray = str.split(",");
           String tempPaperId = /*applyCustomEncrypt*/ ( strArray[0].trim());
           String authorId = /*applyCustomEncrypt*/(strArray[1].trim());
           if(paperId.equals(tempPaperId)){
               if(!authorSet.contains(authorId))
               {
                   builder.append(authorId).append(",");
                   authorSet.add(authorId);
               }else{
                   System.out.println(applyCustomDecrypt(paperId)+" has Duplicate: "+applyCustomDecrypt(authorId));
               }
           }else{
               if(authorSet.size()>1)out.println(builder.substring(0, builder.length()-2));
               paperId = tempPaperId;
               authorSet.clear();
//               System.out.println(builder.toString()+" -->>  "+builder.substring(0, builder.length()-2));
//               builder = new StringBuilder(tempPaperId).append(",").append(authorId).append(",");
               builder = new StringBuilder().append(authorId).append(",");
               authorSet.add(authorId);
               
           }
           double d = ((double)((double)records/total)*100);
           if( d%1 == 0.0 ){
               System.out.println("Percentage : "+d);
           }
           records++;
        }
    }
     
     public static String applyCustomEncrypt(String str){
         str = str.replace('0', 'a');
         str = str.replace('1', 'b');
         str = str.replace('2', 'c');
         str = str.replace('3', 'd');
         str = str.replace('4', 'e');
         str = str.replace('5', 'f');
         str = str.replace('6', 'g');
         str = str.replace('7', 'h');
         str = str.replace('8', 'i');
         str = str.replace('9', 'j');
         str = str.replace('+', 'k');
         return str;
     }
     
      
     public static String applyCustomDecrypt(String str){
         str = str.replace( 'a','0');
         str = str.replace('b','1' );
         str = str.replace( 'c','2');
         str = str.replace('d','3' );
         str = str.replace('e', '4' );
         str = str.replace('f','5');
         str = str.replace('g','6');
         str = str.replace('h','7');
         str = str.replace('i','8');
         str = str.replace('j','9');
         str = str.replace('k','+' );
         return str;
     }
}
