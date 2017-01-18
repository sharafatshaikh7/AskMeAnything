package askmeanythong.com.askmeanythong;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by shara on 1/15/2017.
 */

public class SharedPreference {

    private static Context context;
    private static SharedPreference mSingleton;
    private static final String Login_pref = "Username";
    public static final String DEFAULT = "1";




    private SharedPreference(Context context)
    {
        this.context=context;
    }

    public static synchronized SharedPreference getmSingleton(Context context)
    {
        if (mSingleton ==null)
        {
            mSingleton= new SharedPreference(context);
        }
        return mSingleton;
    }

    public void Loginstatus(String  username,String pass)
    {
        SharedPreferences preferences=context.getSharedPreferences(Login_pref,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("username",username);
        editor.putString("pass",pass);
        editor.commit();
    }
    public boolean getLoginStatus()
    {
        SharedPreferences preferences=context.getSharedPreferences(Login_pref,Context.MODE_PRIVATE);
        if(preferences.contains("username") && preferences.contains("pass"))
        {
            return true;
        }

        String username=preferences.getString("username",DEFAULT);
        String pass=preferences.getString("pass",DEFAULT);
        return false;
    }
    public void deleteLoginPref()
    {
        SharedPreferences preference=context.getSharedPreferences(Login_pref,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preference.edit();
        editor.clear();
        editor.commit();
    }


}
