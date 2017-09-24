// Imports the Google Cloud client library
import com.google.cloud.language.v1.Document;

import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1.EncodingType;
import com.google.cloud.language.v1.Entity;
import com.google.cloud.language.v1.EntityMention;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;

import java.util.List;
import java.util.Map;
import java.io.*;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Object;

public class Natural_Language {

	public static void main(String[] args) throws Exception{

    	File file = new File("temp.txt");
    	String str = file.toString();

    	String location = "";
    	String event = "";
    	String organization = "";

        // Instantiates a client
        try (LanguageServiceClient languageApi = LanguageServiceClient.create()) {
            // The text to analyze
            Document doc = Document.newBuilder()
            .setContent(str)
            .setType(Type.PLAIN_TEXT).build();

            AnalyzeEntitiesRequest request = AnalyzeEntitiesRequest.newBuilder()
                    .setDocument(doc)
                    .setEncodingType(EncodingType.UTF16).build();
            AnalyzeEntitiesResponse response = languageApi.analyzeEntities(request);

            System.out.println(" <------ Entity Analysis -----> ");

            for(Entity entity : response.getEntitiesList()) {

                 String type = (entity.getType()).toString();

                if (type == "LOCATION"){
                    location = entity.getName();
                }
                else if (type == "EVENT"){
                    event = entity.getName();
                }
                else if (type == "ORGANIZATION"){
                    organization = entity.getName();
                }
            }
        }
        catch(FileNotFoundException e){
            location = "";
            event = "";
            organization = "";
        }
        

        String day = "";

        String a = "sund";
        String b = "mon";
        String c = "tue";
        String d = "wed";
        String e = "thur";
        String f = "fri";
        String g = "sat";

        try{
        	Scanner scanner = new Scanner (file);

        	int lineNum = 0;
        	while (scanner.hasNextLine()){
        		
        		String line = scanner.nextLine();
        		lineNum++;
        		if((line).contains(a))day = a;
        		else if((line).contains(b)) day = b;
        		else if((line).contains(c)) day = c;
        		else if((line).contains(d)) day = d;
        		else if((line).contains(e)) day = e;
        		else if((line).contains(f)) day = f;
        		else if((line).contains(g)) day = g;
        	}
        }

        catch(FileNotFoundException e1){
            day = "";
        }


      }
    }


