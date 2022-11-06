package at.feddis08;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static String target_path = "";
    public static String start_url = "";
    public static String end_url = "";
    public static String file_name = "";
    public static Integer start_count = 0;
    public static Integer end_count = 0;

    public static void main(String[] args) throws IOException {
        System.out.println("by Feddis08");
        Scanner input = new Scanner(System.in);
        System.out.println("target_path: ");
        target_path = input.nextLine();
        System.out.println("file_name: ");
        file_name = input.nextLine();
        System.out.println("start_url: ");
        start_url = input.nextLine();
        System.out.println("end_url: ");
        end_url = input.nextLine();
        System.out.println("start_count: ");
        start_count = Integer.parseInt(input.nextLine());
        System.out.println("end_count: ");
        end_count = Integer.parseInt(input.nextLine());
        System.out.println("starting!");
        start();
    }
    public static void get_from_url(String url, String file_name, String path) throws IOException {
        System.out.println("Downloading file: " + url + " " + path + file_name);
        InputStream in = new URL(url).openStream();
        Files.copy(in, Paths.get(path + file_name), StandardCopyOption.REPLACE_EXISTING);
    }
    public static void start() throws IOException {
        Integer index = 0;
        while (index < end_count - start_count){
            try{
                String url = start_url + index + end_url;
                String name = index + start_count + file_name;
                System.out.println("get " + url + " --> " + target_path + "/" + name);
                get_from_url(url, name, target_path + "/");
                index = index + 1;

            }catch (Exception exception){
                System.out.println("Failed to get at: " + index);
                index = index + 1;
            }
        }
    }
}