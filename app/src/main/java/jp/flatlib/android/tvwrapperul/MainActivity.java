// 2019/02/02 Hiroyuki Ogasawara

package jp.flatlib.android.tvwrapperul;

import  android.app.Activity;
import  android.os.Bundle;
import  android.content.ActivityNotFoundException;
import  android.content.pm.PackageManager;
import  android.content.Intent;
import  android.widget.Button;
import  android.view.View;
import  android.provider.Settings;


public class MainActivity extends Activity {


    public void RunPackage( String package_name )
    {
        PackageManager manager= getPackageManager();
        try {
            Intent it= manager.getLaunchIntentForPackage( package_name );
            if( it == null ) {
                return;
            }
            it.addCategory( Intent.CATEGORY_LAUNCHER );
            startActivity( it );
        }catch( ActivityNotFoundException e ){
        }
    }



    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView (R.layout.layout );

        final Button  button1= findViewById( R.id.ButtonUL );
        button1.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ){
                RunPackage( "tech.ula" );
            }
        });
        final Button  button2= findViewById( R.id.ButtonVNC );
        button2.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ){
                RunPackage( "com.realvnc.viewer.android" );
            }
        });
        final Button  button3= findViewById( R.id.ButtonSettings );
        button3.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ){
                startActivity( new Intent( Settings.ACTION_SETTINGS ) );
            }
        });
    }
}
