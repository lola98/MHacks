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

import java.util.List;
import java.util.Map;

public class Analyze {
  public static void main(String... args) throws Exception {
    // Instantiates a client
    try (LanguageServiceClient languageApi = LanguageServiceClient.create()) {

      // The text to analyze
      String text = "My name is Alex and I am throwing a party on Halloween";
      Document doc = Document.newBuilder()
          .setContent(text).setType(Type.PLAIN_TEXT).build();

      // Detects the entity of the text
      analyzeEntity(languageApi, doc);
    }
  }
      
  public static void analyseEntity(LanguageServiceClient languageApi, Document doc) {

    AnalyzeEntityRequest request = AnalyzeEntityRequest.newBuilder()
            .setDocument(doc)
            .setEncodingType(EncodingType.UTF16).build();
    AnalyzeEntityResponse response = languageApi.analyzeEntitySentiment(request);

    System.out.println(" <------ Entity Analysis -----> ");

    for(Entity entity : response.getEntitiesList())
    {
      System.out.println();
      System.out.println("Name      : " + entity.getName());
      System.out.println("Type      : " + entity.getType().name());
    }
  }
}