package bronheeres.politie;

import android.content.Context;
import android.content.SharedPreferences;


public class ReadCounter {
    private static final String PREFRENCE_NAME = "hoofdstukken";
    private static final String HOOFDSTUK1 = "h1";
    private static final String HOOFDSTUK2 = "h2";
    private static final String HOOFDSTUK3 = "h3";
    private static final String HOOFDSTUK4 = "h4";

    private static Context context;

    public static void setContext(Context con)
    {
        context = con;
    }
    public static void setData(Context context, int[] views)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFRENCE_NAME, Context.MODE_PRIVATE).edit();
        editor.putInt(HOOFDSTUK1, views[0]);
        editor.putInt(HOOFDSTUK2, views[1]);
        editor.putInt(HOOFDSTUK3, views[2]);
        editor.putInt(HOOFDSTUK4, views[3]);

        editor.apply();
    }

    public static int[] getData()
    {
        int[] aantal = new int[4];
        SharedPreferences pref = context.getSharedPreferences(PREFRENCE_NAME, Context.MODE_PRIVATE);
        aantal[0] = pref.getInt(HOOFDSTUK1, 0);
        aantal[1] = pref.getInt(HOOFDSTUK2, 0);
        aantal[2] = pref.getInt(HOOFDSTUK3, 0);
        aantal[3] = pref.getInt(HOOFDSTUK4, 0);
        return aantal;
    }

    public static void addPagina(Context context, int pagina)
    {
        int[] original = getData();
        original[pagina]++;
        setData(context, original);
    }

}
