import java.util.ArrayList;
public class ListaEnlazada {



    //creacion de una lista doblemente enlazada que contendra los nodos o datos para las historias de viajes en el tiempo.

    public ArrayList<String> historias = new ArrayList<>();
    public static class Nodo {


        char evento; //De tipo A pasado , B presente o C futuro.
        String cientifico; // Hay dos tipos de cientifico marty mcfly o emmet brown.
        int dato; //el numero que contiene el nodo y que servira para comparar si es primo o coprimo.

        Nodo LLink; // Enlace izquierdo
        Nodo RLink; // Enlace derecho
    }
    public Nodo ptr; // Primer elemento de la lista




    public void addElemento(int elem, String cientifico, char evento) { // este metodo le asigna los datos al nodo verificando si esta vacio primero y luego recorriendo la lista hasta el final para agregar el elemento.
        Nodo nuevo = new Nodo(); // Crear nuevo nodo

        if (ptr == null) { // Si la lista esta vacía
            nuevo.dato = elem;
            nuevo.cientifico = cientifico;
            nuevo.evento = evento;
            ptr = nuevo;
        } else {
            // Si la lista no está vacía la recorremos hasta llegar al final, para agregar el nuevo elemento de último.
            Nodo ant = ptr;
            Nodo p = ptr.RLink;

            while (p != null) {
                ant = p;
                p = p.RLink;
            }


            // si p que definimos como el nodo a la derecha siguiente esta vacio, agragamos los datos y modificamos la direccion de los nodos.
            nuevo.dato = elem;
            nuevo.cientifico = cientifico;
            nuevo.evento = evento;
            nuevo.LLink = ant;
            nuevo.RLink = null;
            ant.RLink = nuevo;
        }
    }


    public void mostrarLista() { //Este metodo imprime los datos de la lista verificando primero si la lista esta vacia.
        if (ptr == null) {
            System.out.println("No hay elementos en la lista");
        } else {
            Nodo p = ptr;
            while (p.RLink != null) {
                System.out.print(p.dato + " | " + p.cientifico + " | " + p.evento  + " // ");

                p = p.RLink;

            }
            System.out.print(p.dato + " | " + p.cientifico + " | " + p.evento + " \n ");
        }

    }

    public void mostrarHistorias(){   //Este metodo se compone de un ciclo for para recorrer la lista de historias e imprimir el tipo de historia.
        for (String x: historias){
            System.out.println(x);
        }
    }





    public Nodo buscarUltimoNodo() {   //Este metodo empeiza desde el puntero y compara el nodo de la derecha hasta que este nodo sea null para recorrer todos los nodos siguientes y llegar al ultimo.
        Nodo temp = ptr;
        while (temp.RLink != null) {
            temp = temp.RLink;
        }
        return temp;
    }

     public Nodo buscarA(){   //este metodo asigna una variable que sera el ultimo elemento de la lista y lo recorre hacia atras hasta encontrar el ultimo evento A.
        Nodo temp1 = buscarUltimoNodo();
         while (temp1.LLink.evento != 'A') {
            temp1 = temp1.LLink;}
        return temp1;
    }


    // Función que recibe un ArrayList de tipo int
    public void contadorDeEventos(ArrayList<Integer> lista) {

        if (ptr == null) {
            System.out.println("No hay elementos en la lista");
        } else {
            Nodo p = ptr;
            while (p.RLink != null) {
                if(p.evento == 'A'){
                    lista.set(0, lista.get(0)+1);

                } else if (p.evento == 'B') {
                    lista.set(1, lista.get(1)+1);


                }else if (p.evento == 'C'){
                    lista.set(2, lista.get(2)+1);

                }
                p = p.RLink;

            }
            if(p.evento == 'A'){
                lista.set(0, lista.get(0)+1);

            } else if (p.evento == 'B') {
                lista.set(1, lista.get(1)+1);


            }else if (p.evento == 'C'){
                lista.set(2, lista.get(2)+1);

            }
        }

    }







}