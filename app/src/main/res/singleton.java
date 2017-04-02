/**
 * Created by Administrator on 3/23/2017.
 */
public class singleton {
    private static singleton ourInstance = new singleton();

    public static singleton getInstance() {
        return ourInstance;
    }

    private singleton() {
    }
}
