

import java.util.ArrayList;
public class Run {


    public  void run() {
        ArrayList<ListaEnlazada> historiass = new ArrayList<>();
        Processing process = new Processing();

        // verificar el ultimo elemento de la lista y su numero de nodos creados si no crear una nueva lista.

        int contador = 22;

        while (contador > 0) {

            if (historiass.size() == 0) {  //Compara que el tamaño de la lista sea 0 y crea una nueva lista si es el caso.
                ListaEnlazada lista = new ListaEnlazada();
                historiass.add(lista);
                int nv = process.numeroAleatorio();
                lista.addElemento(nv, process.nombreCientifico(), 'A');
                contador -= 1;


            } else {
                ListaEnlazada continuacion = historiass.get(historiass.size() - 1); // Selecciona el ultimo nodo de la lista y verifica si se creo una historia si no se creo crea una nueva y esa se convierte en la ultima historia de la lista.
                boolean verificacion = process.crearHistoria(continuacion);
                if (!verificacion) {
                    ListaEnlazada lista = new ListaEnlazada();
                    int nv = process.numeroAleatorio();
                    lista.addElemento(nv, process.nombreCientifico(), 'A');
                    historiass.add(lista);

                }
                contador -= 1;

            }

        }

        ArrayList<Integer> contadorEventos = new ArrayList<Integer>(); //Creamos un array de numeros al que le vamos a asignar un evento por posicion.
        contadorEventos.add(0, 0);
        contadorEventos.add(1, 0);
        contadorEventos.add(2, 0);


        for(ListaEnlazada x :historiass) { //Ese for recorre la lista y ejecuta esos metodos por cada elemento e imprime el total de los tipos de evento.
            x.mostrarLista();
            x.mostrarHistorias();
            x.contadorDeEventos(contadorEventos);

        }
        System.out.println("Los eventos tipo A fueron: "+  contadorEventos.get(0));
        System.out.println("Los eventos tipo B fueron: "+  contadorEventos.get(1));
        System.out.println("Los eventos tipo C fueron: "+  contadorEventos.get(2));



    }


}
