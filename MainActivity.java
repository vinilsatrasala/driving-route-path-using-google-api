package com.example.drivingdirectionsample;

import java.util.ArrayList;

import android.os.Bundle;
import android.graphics.Color;

import com.android.riktamtech.drivingdirections.DrawRoutePath;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
public class MainActivity extends MapActivity {
	ArrayList<GeoPoint> points =new ArrayList<GeoPoint>();
	DrawRoutePath drawRoutePath;
	ArrayList<String> drivingDirections=new ArrayList<String>();
	ArrayList<String> drivingDistance=new ArrayList<String>();
	MapView map;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map=(MapView) findViewById(R.id.starandcurrentmaplocation);
        map.setBuiltInZoomControls(true);
        GeoPoint point = new GeoPoint((int)(17.3667*1E6),(int)(78.4667*1E6));
        GeoPoint point1 = new GeoPoint((int)(12.9833*1E6),(int)(77.5833*1E6));
        points.add(point);
        points.add(point1);
        for(int i=0;i<points.size()-1;i++){
        	//we need to pass the parameters as starting point, destination point,colour of map,map view,index,type of path
        	//if you want walking directions send it as "isWalkPath"
        	//if you want bicycle directions send it as "isBicyclePath"
        	//if you want Transit directions send it as "isTransitPath"
        	//if you want Air directions send it as "isAirPath"
        	//if you want driving directions send it as null
        	
        	drawRoutePath=new DrawRoutePath(points.get(i), points.get(i+1), Color.BLUE, map , i,"isWalkPath");
        	 drivingDirections.addAll(drawRoutePath.getDrivingDirections());
        	 drivingDistance.add(drawRoutePath.getDistanceBetweenPoints());
        }
    }
//this method is used to display the path
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return true;
	}

    

    
}
