import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


class Zipped<T> implements Stream.Builder<T>{

    private List<T> container = null;

    public Stream<T> build(){
        return container.stream();
    }

    public void accept(T obj){
        if(container == null){
            container = new ArrayList<T>();
        }
        if (obj!= null)
            container.add(obj);
    }

    public Stream.Builder<T> add (T obj){
        accept(obj);
        return this;
    }
}

/**
 * Class to merge two input streams into one stream that alternates their elements
 */

public class StreamZipper {

    public static Stream zip(Stream fStream, Stream sStream){
        Zipped<Object> zipped = new Zipped<Object>();
        Object[] fList= fStream.toArray();
        Object[] sList = sStream.toArray();
        int length = Math.min(fList.length, sList.length);
        for (int i = 0; i < length; ++i){
            zipped.add(fList[i]);
            zipped.add(sList[i]);
        }
        return zipped.build();
    }
}

