//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.Scanner;
//
/////*
//// * To change this template, choose Tools | Templates
//// * and open the template in the editor.
//// */
////package wordanalyser;
////
////import java.io.IOException;
////import java.io.Serializable;
////import java.util.ArrayList;
////import java.util.Arrays;
////import java.util.List;
////import org.apache.lucene.analysis.en.*;
////import static wordanalyser.main.FILE_NAME;
////
/////**
//// *
//// * @author Ali Souri
//// */
////public class textAnalyser implements Serializable{
////
//////    public textAnalyser() {
//////    }
////    
////    public String textDataAnalyser(main handler) throws IOException{
////       List<String> lines = handler.readSmallTextFile(FILE_NAME);
////        ArrayList<String> lines1 = null;
////        int size = 0;
////        int linemasize = 0;
////        String linema[] = null;
////        String filesjg1[] = {"first"};
////        List listt1 = new ArrayList(Arrays.asList(filesjg1));
////        try {
////            for (int i = 0; i < lines.size(); i++) {
////                linema = lines.get(i).split(" ");
////                listt1.addAll(Arrays.asList(linema));
////                size = size + linema.length;
////            }
////            Object[] c = listt1.toArray();
////                System.out.println(Arrays.toString(c));
////                System.out.println("The size is:"+size);
////            
////            
////        } catch (Exception e) {
////            System.out.println("chi mige?");
////        }
////       // String sherover = Arrays.toString(c);
////    return "";
////}
////}
// void readLargerTextFile(String aFileName) throws IOException {
//        Path path = Paths.get(aFileName);
//        try (Scanner scanner = new Scanner(path, ENCODING.name())) {
//            while (scanner.hasNextLine()) {
//                // log(scanner.nextLine());
//            }
//        }
//    }
//
//    void readLargerTextFileAlternate(String aFileName) throws IOException {
//        Path path = Paths.get(aFileName);
//        try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)) {
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                //  log(line);
//            }
//        }
//    }
//
//    void writeLargerTextFile(String aFileName, List<String> aLines) throws IOException {
//        Path path = Paths.get(aFileName);
//        try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)) {
//            for (String line : aLines) {
//                writer.write(line);
//                writer.newLine();
//            }
//        }
//    }
