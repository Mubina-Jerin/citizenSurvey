package citizenSurvey;

import au.com.bytecode.opencsv.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;


public class csvReader {
	private static final String csvFilePath = "surveySample.csv";

    public static void main(String[] args) throws IOException {
    	
    	try {
    		 Reader readerObject = Files.newBufferedReader(Paths.get(csvFilePath));
             CSVReader csvReader = new CSVReader(readerObject);
             
             String[] currentLine;
             
             List<String> keyNames= new ArrayList<String>();
            
             HashMap<String, List<String>> map = new HashMap<String, List<String>>();
             int i=0;
             int j=0;
             int n=0;
            
             while ((currentLine = csvReader.readNext()) != null) {
            		  
            	 if(i==0) {
            		 System.out.print("All Search Criteria Names are:\t");
            		 for(n=0;n<currentLine.length;n++) {
            			 keyNames.add(currentLine[n]);
            			 System.out.print(currentLine[n]+"\t");
            		 }
            		 System.out.println("");
            	 }
                 
            	 
            	 String LineNumber="Line"+Integer.toString(i);
                 map.put(LineNumber, new ArrayList<String>());
                
                 for(n=0;n<currentLine.length;n++) {
                  	  map.get(LineNumber).add(currentLine[n]);
                  }
                  	 i++;
                  	//System.out.println("=========================="+ i);
             }
          
             //System.out.println("=========================="+ i);
             
             // For the Application For Optimal Search in terms of Search:
             
             //Enter data using BufferReader 
         	 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
             BufferedReader categoryName = new BufferedReader(new InputStreamReader(System.in));
             // Reading data using readLine 
             System.out.println("Enter a Search Criteria");
             String serarchByCriteria = reader.readLine();
            
             int t;
                         
       	 for(t=0;t<keyNames.size();t++)
       	 {
           
           if(keyNames.get(t).equalsIgnoreCase(serarchByCriteria)) {
        	  System.out.println("You Are Entering The List Related with Criteria \t"+keyNames.get(t));
        	  System.out.println("Enter a Search Term");
              String searchTerm=categoryName.readLine();
              int count=0;
              for(Map.Entry<String, List<String>> element:map.entrySet()) {
            	
                			 if(element.getValue().get(t).equalsIgnoreCase(searchTerm)) {
                				  System.out.println("\n\nFound at "+ element.getKey()); 
                				  System.out.print(keyNames.get(0)+":\t"+element.getValue().get(0) +"\n");
                				  System.out.print(keyNames.get(1)+":\t"+element.getValue().get(1) +"\n");
                				  System.out.print(keyNames.get(2)+":\t"+element.getValue().get(2) +"\n");
                				  System.out.print(keyNames.get(3)+":\t"+element.getValue().get(3) +"\n");
                				  System.out.print(keyNames.get(4)+":\t"+element.getValue().get(4) +"\n");
                				  System.out.print(keyNames.get(5)+":\t"+element.getValue().get(5) +"\n");
                			      count++;	    
                				 }
                		  }
              System.out.println("\n\nTotal record Found Based on the search Term\t"+searchTerm +":\t"+ count);
            	}
           else{
        	   if(t==keyNames.size()-1){ 
                    System.out.println("Criteria doesn't Exsist");
        	   }
             }   
           }
   		
       	   		 
            
            
			          
       }
    catch(Exception e) {
    		System.out.println("Error");
    		e.printStackTrace();
       }
    	
    	
 	
}
    

}
