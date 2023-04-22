import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        try{
            String fileName = args[0];
            if(!fileName.endsWith(".arxml")){
                throw new NotVaildAutosarFileException();
            }
            File file = new File(fileName);
            FileInputStream inputStream = new FileInputStream(file);
            int m;
            StringBuilder stringBuilder = new StringBuilder();
            if (file.length() == 0 ){
                throw new RuntimeException("EmptyAutosarFileException");
            }
            while((m=inputStream.read()) != -1){
                stringBuilder.append((char) m);
            }

            String data = stringBuilder.toString();
            Scanner scanner = new Scanner(data);
            ArrayList<CONTAINER>  CONTAINERS = new ArrayList<>();
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.contains("<CONTAINER")){
                    String UUID = line.substring(line.indexOf("UUID="),line.indexOf(">"));
                    String shortNAMETag = scanner.nextLine();
                    String shortName = shortNAMETag.substring(shortNAMETag.indexOf(">")+1,shortNAMETag.indexOf("</"));
                    String longNAMETag = scanner.nextLine();
                    String longName = longNAMETag.substring(longNAMETag.indexOf(">")+1,longNAMETag.indexOf("</"));
                    CONTAINER container = new CONTAINER();
                    container.setUUID(UUID);
                    container.setShortNameTag(shortName);
                    container.setLongNameTag(longName);
                    CONTAINERS.add(container);
                }
            }
            Collections.sort(CONTAINERS);
            String outputName = fileName.substring(0,fileName.indexOf("."))+"_mod.arxml";
            FileOutputStream   outputstream = new FileOutputStream(outputName);
            outputstream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            outputstream.write("<AUTOSAR>\n\n".getBytes());
            for (int i =0; i< CONTAINERS.size(); i++){
               outputstream.write(CONTAINERS.get(i).toString().getBytes());
            }

            outputstream.write("<AUTOSAR>\n".getBytes());

        }  catch(NotVaildAutosarFileException e){
            e = new NotVaildAutosarFileException("Not valid Autosar file");
        }
        catch(FileNotFoundException e) {
            e = new FileNotFoundException("File  is not found!");
        }
        catch (IOException e){
            e = new IOException("IOException!");

        }


        

        }
}