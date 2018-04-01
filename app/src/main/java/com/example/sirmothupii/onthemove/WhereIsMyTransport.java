package com.example.sirmothupii.onthemove;

import android.graphics.Point;
import android.icu.text.TimeZoneFormat;
import android.location.Location;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import transportapisdk.AgencyQueryOptions;
import transportapisdk.TransportApiClient;
import transportapisdk.TransportApiClientSettings;
import transportapisdk.TransportApiResult;
import transportapisdk.models.Agency;

public class WhereIsMyTransport extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private String address;
    private Point geometry;
    private int id;
    private TransportApiResult<List<Agency>> mAgencies;
    TransportApiClient defaultClient;
    private static final String CLIENT_ID = "c553e9f7-d93d-40c8-a981-31f71ca7c556";
    private static final String CLIENT_SECRET = "KUeRav3HKDm9etKQmWyICUlSU574XrnSi392oGGRayY=";
    private final double myLat = -26.0425652;
    private final double myLong = 28.0146813;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        defaultClient = new TransportApiClient(new TransportApiClientSettings(CLIENT_ID, CLIENT_SECRET));
        mAgencies = defaultClient.getAgencies(AgencyQueryOptions.defaultQueryOptions());
        //defaultClient.geta
        Agency agency = null;

        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    ///DO NOT DELETE THESE METHODS


    public TransportApiResult<List<Agency>> find()
    {
        return defaultClient.getAgenciesNearby(AgencyQueryOptions.defaultQueryOptions(), myLat, myLong, 300);
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_jorney)
        {
            // Handle the journey action
            class Journey
            {
                private String id;
                private String href;
                private MultiPoint geometry;
                private String time;
                private TimeZoneFormat.TimeType timeType;
                private ContactsContract.Profile profile;
                private Only only;
                private Omit omit;
                private int maxItineraries;
                private List<String> fareProducts = new ArrayList<String>();
                private List<Itinerary> itineraries = new ArrayList<Itinerary>();

                /**
                 * @return The id
                 */
                public String getId()
                {
                    return id;
                }

                /**
                 * @param id The id
                 */
                public void setId(String id) {
                    this.id = id;
                }

                /**
                 * @return The href
                 */
                public String getHref() {
                    return href;
                }

                /**
                 * @param href The href
                 */
                public void setHref(String href) {
                    this.href = href;
                }

                /**
                 * @return The time
                 */
                public String getTime() {
                    return time;
                }

                /**
                 * @param time The time
                 */
                public void setTime(String time) {
                    this.time = time;
                }

                /**
                 * @return The timeType
                 */
                public TimeZoneFormat.TimeType getTimeType() {
                    return timeType;
                }

                /**
                 * @param timeType The timeType
                 */
                public void setTimeType(TimeZoneFormat.TimeType timeType) {
                    this.timeType = timeType;
                }

                /**
                 * @return The profile
                 */
                public ContactsContract.Profile getProfile() {
                    return profile;
                }

                /**
                 * @param profile The profile
                 */
                public void setProfile(ContactsContract.Profile profile) {
                    this.profile = profile;
                }

                /**
                 * @return The geometry
                 */
                public MultiPoint getGeometry() {
                    return geometry;
                }

                /**
                 * @param geometry The geometry
                 */
                public void setGeometry(MultiPoint geometry) {
                    this.geometry = geometry;
                }

                /**
                 * @return The maxItineraries
                 */
                public int getMaxItineraries() {
                    return maxItineraries;
                }

                /**
                 * @param maxItineraries The maxItineraries
                 */
                public void setMaxItineraries(int maxItineraries) {
                    this.maxItineraries = maxItineraries;
                }

                /**
                 * @return The fareProducts
                 */
                public List<String> getFareProducts() {
                    return fareProducts;
                }

                /**
                 * @param fareProducts The fareProducts
                 */
                public void setFareProducts(List<String> fareProducts) {
                    this.fareProducts = fareProducts;
                }

                /**
                 * @return The itineraries
                 */
                public List<Itinerary> getItineraries() {
                    return itineraries;
                }

                /**
                 * @param itineraries The itineraries
                 */
                public void setItineraries(List<Itinerary> itineraries) {
                    this.itineraries = itineraries;
                }

                /**
                 * @return The only objects used in the call.
                 */
                public Only getOnly() {
                    return only;
                }

                /**
                 * @param only The only objects used in the call.
                 */
                public void setOnly(Only only) {
                    this.only = only;
                }

                /**
                 * @return The objects omitted from the call.
                 */
                public Omit getOmit() {
                    return omit;
                }

                /**
                 * @param omit The objects omitted from the call.
                 */
                public void setOmit(Omit omit) {
                    this.omit = omit;
                }
            }
        } else if (id == R.id.nav_maps) {
            class Location {
                String address;
                Point geometry;
            }
        }
        return true;
    }

    /**
     * @return The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return The geometry
     */
    public boolean getGeometry() {
        return true;
    }

    /**
     * @param geometry The geometry
     */
    public boolean setGeometry(Point geometry) {
        this.geometry = geometry;

        if (id == R.id.nav_scan) {

        } else if (id == R.id.nav_Fare) {
            class Fare {
                private String description;
                private FareProduct fareProduct;
                private Cost cost;
                private List<String> messages = new ArrayList<String>();

                /**
                 * @return The description
                 */
                public String getDescription() {
                    return description;
                }

                /**
                 * @param description The description
                 */
                public void setDescription(String description) {
                    this.description = description;
                }

                /**
                 * @return The fareProduct
                 */
                public FareProduct getFareProduct() {
                    return fareProduct;
                }

                /**
                 * @param fareProduct The fareProduct
                 */
                public void setFareProduct(FareProduct fareProduct) {
                    this.fareProduct = fareProduct;
                }

                /**
                 * @return The cost
                 */
                public Cost getCost() {
                    return cost;
                }

                /**
                 * @param cost The cost
                 */
                public void setCost(Cost cost) {
                    this.cost = cost;
                }

                /**
                 * @return The messages
                 */
                public List<String> getMessages() {
                    return messages;
                }

                /**
                 * @param messages The messages
                 */
                public void setMessages(List<String> messages) {
                    this.messages = messages;
                }
            }
        } else if (id == R.id.nav_facebook) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
