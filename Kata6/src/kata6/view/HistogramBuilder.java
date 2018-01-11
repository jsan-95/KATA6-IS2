
package kata6.view;


import java.util.ArrayList;
import java.util.function.Consumer;
import kata6.Attribute;
import kata6.model.Histogram;


public class HistogramBuilder<T> {
    private final ArrayList <T> lista;
    
    public HistogramBuilder(ArrayList<T> lista) {
        this.lista = lista;
    }
    
    public <A>Histogram<A> build(Attribute<T,A> attribute){
        Histogram <A> histo = new Histogram<>();
        lista.forEach(new Consumer<T>() {
            @Override
            public void accept(T lista1) {
                A value = attribute.get(lista1);
                histo.increment(value);
            }
        });
        return histo;
        
    }
}
