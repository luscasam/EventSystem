package eventsystem;

import java.io.*;
import java.util.List;

public class Persistence {
    public static <T> void saveData(List<T> data, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(data);
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> loadData(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<T>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new java.util.ArrayList<>();
        }
    }
}
