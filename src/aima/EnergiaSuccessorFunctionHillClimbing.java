package aima;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

import java.util.ArrayList;
import java.util.List;

public class EnergiaSuccessorFunctionHillClimbing implements SuccessorFunction {
    @Override
    public List getSuccessors(Object o) {
        @SuppressWarnings("unchecked")
        ArrayList                retVal = new ArrayList();
        EnergiaEstado            estatVell  = (EnergiaEstado) o;
        EnergiaHeuristicFunction HF  = new EnergiaHeuristicFunction();

        // Moure clients
        for (int i = 0; i < estatVell.getNClientes(); i++) {
            for (int j = -1; j < estatVell.getNCentrales(); j++) {
                if(estatVell.sePuedeMoverCliente(i, j)) {
                    EnergiaEstado estatNou = new EnergiaEstado(estatVell);
                    estatNou.moverCliente(i, j);

                    retVal.add(new Successor("", estatNou));

                }
            }
        }

//        // Intercanviar clients amb clients
//        for (int i = 0; i < estatVell.getNClientes(); i++) {
//            for (int j = i+1; j < estatVell.getNClientes(); j++) {
//                if(estatVell.sePuedenIntercambiarClientes(i, j)) {
//                    EnergiaEstado estatNou = new EnergiaEstado(estatVell);
//                    estatNou.intercambiarClientes(i, j);
//
//                    retVal.add(new Successor("", estatNou));
//
//                }
//            }
//        }
//
//        // Buidar central
//        for (int i = -1; i < estatVell.getNCentrales(); i++) {
//            for (int j = -1; j < estatVell.getNCentrales(); j++) {
//                if(estatVell.sePuedeVaciarCentral(i, j)) {
//                    EnergiaEstado estatNou = new EnergiaEstado(estatVell);
//                    estatNou.vaciarCentral(i, j);
//
//                    retVal.add(new Successor("", estatNou));
//
//                }
//            }
//        }

        return retVal;
    }
}
