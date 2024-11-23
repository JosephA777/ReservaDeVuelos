import java.util.Scanner;

public class ReservaDeVuelos {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Variables
        String nombre, apellido, cedula, d, m, a;
        int boleto, Nmaleta, P1maleta, P2maleta, Tmaleta, eleccion, asientos = 0;
        double Pboleto = 0, Fprecio;

        // Entrada de datos del usuario
        System.out.println("Ingrese su primer Nombre y su primer Apellido:");
        System.out.print("Primer Nombre: ");
        nombre = input.nextLine();
        System.out.print("Primer Apellido: ");
        apellido = input.nextLine();
        System.out.print("Ingrese su cedula: ");
        cedula = input.nextLine();
        System.out.println("Ingrese su fecha de nacimiento:");
        System.out.print("Dia: ");
        d = input.nextLine();
        System.out.print("Mes: ");
        m = input.nextLine();
        System.out.print("Año: ");
        a = input.nextLine();

        System.out.println("Señor " + nombre + " " + apellido + " con cédula " + cedula + 
                           " y fecha de nacimiento " + d + "/" + m + "/" + a);

        // Selección de tipo de boleto
        do {
            System.out.println("Qué tipo de boleto desea?");
            System.out.println("1. Primera clase ($900)");
            System.out.println("2. Clase ejecutiva ($700)");
            System.out.println("3. Clase económica ($500)");
            boleto = input.nextInt();

            switch (boleto) {
                case 1:
                    Pboleto = 900;
                    asientos = 10;
                    System.out.println("El boleto de Primera clase cuesta $900");
                    System.out.println("Actualmente hay: " + asientos + " asientos disponibles.");
                    asientos--;
                    System.out.println("Asientos restantes: " + asientos);
                    System.out.println("La Ruta para pasajeros de Primera clase es la Ruta N1.");
                    break;
                case 2:
                    Pboleto = 700;
                    asientos = 50;
                    System.out.println("El boleto de Clase ejecutiva cuesta $700");
                    System.out.println("Actualmente hay: " + asientos + " asientos disponibles.");
                    asientos--;
                    System.out.println("Asientos restantes: " + asientos);
                    System.out.println("La Ruta para pasajeros de Clase ejecutiva es la Ruta N2.");
                    break;
                case 3:
                    Pboleto = 500;
                    asientos = 120;
                    System.out.println("El boleto de Clase económica cuesta $500");
                    System.out.println("Actualmente hay: " + asientos + " asientos disponibles.");
                    asientos--;
                    System.out.println("Asientos restantes: " + asientos);
                    System.out.println("La Ruta para pasajeros de Clase económica es la Ruta N3.");
                    break;
                default:
                    System.out.println("El número " + boleto + " no es válido. Inténtelo de nuevo.");
            }
        } while (boleto < 1 || boleto > 3);

        // Manejo de equipaje
        do {
            System.out.println("Ingrese la cantidad de maletas que lleva (máximo 2): ");
            Nmaleta = input.nextInt();

            if (Nmaleta == 2) {
                do {
                    System.out.println("Ingrese el peso de cada maleta (El peso total no debe pasar de 46 kg):");
                    System.out.print("Primera maleta: ");
                    P1maleta = input.nextInt();
                    System.out.print("Segunda maleta: ");
                    P2maleta = input.nextInt();
                    Tmaleta = P1maleta + P2maleta;

                    if (Tmaleta <= 46) {
                        System.out.println(Tmaleta + " kg es un peso válido.");
                    } else {
                        System.out.println(Tmaleta + " kg excede el límite de peso.");
                        System.out.println("Reduzca el peso de las maletas...");
                    }
                } while (Tmaleta > 46);
            } else if (Nmaleta == 1) {
                do {
                    System.out.println("Ingrese el peso de la maleta (no debe pasar de 46 kg): ");
                    P1maleta = input.nextInt();
                    if (P1maleta <= 46) {
                        System.out.println(P1maleta + " kg es un peso válido.");
                    } else {
                        System.out.println(P1maleta + " kg excede el límite de peso.");
                        System.out.println("Reduzca el peso de la maleta...");
                    }
                } while (P1maleta > 46);
            } else if (Nmaleta > 2) {
                System.out.println("Excede la cantidad de maletas admitidas.");
            } else {
                System.out.println("Si no lleva maletas, continuamos.");
            }
        } while (Nmaleta > 2 || Nmaleta < 0);

        // Cancelación del boleto
        do {
            System.out.println("¿Desea hacer alguna cancelación? (Si=1 / No=0): ");
            eleccion = input.nextInt();

            if (eleccion == 1) {
                Fprecio = Pboleto * 0.20;
                System.out.println("Se aplicará una multa del 20%.");
                System.out.println("Multa por pagar: $" + Fprecio);
            } else if (eleccion == 0) {
                Fprecio = Pboleto;
                System.out.println("No se aplicará multa.");
            } else {
                System.out.println(eleccion + " no es válido.");
            }
        } while (eleccion != 0 && eleccion != 1);

        System.out.println("Gracias por su colaboración.");
        input.close();
    }
}