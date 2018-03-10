package utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Keren on 11/01/2018.
 */

public class SharedPreferencesManager {


        private SharedPreferences mSharedPreferencesFile;
        private static SharedPreferencesManager mHomeSharedPreferences = null;

        private SharedPreferencesManager(Context context)
        {
            mSharedPreferencesFile = context.getSharedPreferences(ConstantsClass.SHARED_PREFS, Context.MODE_PRIVATE);
        }

        public static synchronized SharedPreferencesManager getInstance(Context context)
        {

            if (mHomeSharedPreferences == null)
            {
                mHomeSharedPreferences = new SharedPreferencesManager(context);
            }

            return mHomeSharedPreferences;
        }

        public void putBooleanSharedPreferences(String key, boolean keyValue)
        {

            if (mSharedPreferencesFile != null)
            {
                SharedPreferences.Editor editor = mSharedPreferencesFile.edit();
                editor.putBoolean(key, keyValue);
                editor.apply();
            }
        }

        public void putStringSharedPreferences(String key, String keyValue)
        {

            if (mSharedPreferencesFile != null)
            {
                SharedPreferences.Editor editor = mSharedPreferencesFile.edit();
                editor.putString(key, keyValue);
                editor.apply();
            }
        }

        public void putIntSharedPreferences(String key, int keyValue)
        {

            if (mSharedPreferencesFile != null)
            {
                SharedPreferences.Editor editor = mSharedPreferencesFile.edit();
                editor.putInt(key, keyValue);
                editor.apply();
            }
        }

        public String getStringSharedPreferences(String key, String defValue)
        {

            if (mSharedPreferencesFile != null)
                return mSharedPreferencesFile.getString(key, defValue);

            return defValue;
        }

        public boolean getBooleanSharedPreferences(String key, boolean defValue)
        {

            if (mSharedPreferencesFile != null)
                return mSharedPreferencesFile.getBoolean(key, defValue);

            return defValue;
        }

        public int getIntSharedPreferences(String key, int defValue)
        {

            if (mSharedPreferencesFile != null)
                return mSharedPreferencesFile.getInt(key, defValue);

            return defValue;

        }

        public boolean contains(String key)
        {

            if (mSharedPreferencesFile != null)
                return mSharedPreferencesFile.contains(key);

            return false;

        }

        public void removeKey(String keyToRemove)
        {

            if (mSharedPreferencesFile != null)
            {

                SharedPreferences.Editor editor = mSharedPreferencesFile.edit();
                editor.remove(keyToRemove);
                editor.apply();
            }
        }

        public void deleteSharedPrefrence()
        {

            if (mSharedPreferencesFile != null)
            {

                mSharedPreferencesFile.edit().clear().commit();
            }
        }

        public void deleteSharedPrefrence(String key)
        {

            if (mSharedPreferencesFile != null)
            {

                mSharedPreferencesFile.edit().clear().commit();
            }
        }




}
