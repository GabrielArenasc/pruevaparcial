
import java.io.*;
import java.util.*;

public class RestauranteSimulador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> pedido = new ArrayList<>();
        
        // Menú inicial
        while (true) {
            System.out.println("Menú disponible:");
            System.out.println("1. Pizza");
            System.out.println("2. Lasaña");
            System.out.println("3. Postre");
            System.out.println("4. Cuenta");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    mostrarMenu("Pizza", pedido, scanner);
                    break;
                case 2:
                    mostrarMenu("Lasaña", pedido, scanner);
                    break;
                case 3:
                    mostrarMenu("Postre", pedido, scanner);
                    break;
                case 4:
                    mostrarCuenta(pedido);
                    break;
                case 5:
                    guardarPedido(pedido);
                    System.out.println("Gracias por visitar el restaurante. ¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
    
    private static void mostrarMenu(String tipo, List<String> pedido, Scanner scanner) {
        List<String> opciones = new ArrayList<>();
        
        // Definir las opciones del menú
        if (tipo.equals("Pizza")) {
            opciones = Arrays.asList("Peperoni", "Carnes", "Tocineta y Ciruela", "Volver");
        } else if (tipo.equals("Lasaña")) {
            opciones = Arrays.asList("Carnes", "Pollo", "Mixta", "Volver");
        } else if (tipo.equals("Postre")) {
            opciones = Arrays.asList("Maltealda", "Brownie", "Helado", "Volver");
        }
        
        while (true) {
            System.out.println("Menú " + tipo + ":");
            for (int i = 0; i < opciones.size(); i++) {
                System.out.println((i + 1) + ". " + opciones.get(i));
            }
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            
            if (opcion >= 1 && opcion <= opciones.size()) {
                if (opcion == opciones.size()) {
                    // Volver al menú anterior
                    break;
                } else {
                    // Agregar la opción al pedido
                    pedido.add(tipo + " - " + opciones.get(opcion - 1));
                    System.out.println("¡Pedido agregado!");
                }
            } else {
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
    
    private static void mostrarCuenta(List<String> pedido) {
        System.out.println("Cuenta:");
        for (String item : pedido) {
            System.out.println(item);
        }
    }
    
    private static void guardarPedido(List<String> pedido) {
        try {
            FileWriter writer = new FileWriter("pedido.txt");
            for (String item : pedido) {
                writer.write(item + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Error al guardar el pedido.");
        }
    }
}