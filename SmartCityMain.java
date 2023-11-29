import java.util.*;

interface Sensor {
    double measure(); // Simulate measuring data
}

// Base class for Sensors
abstract class BaseSensor implements Sensor {
    private String sensorId;

    public BaseSensor(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorId() {
        return sensorId;
    }
}

// Air Quality Sensor class
class AirQualitySensor extends BaseSensor {
    public AirQualitySensor(String sensorId) {
        super(sensorId);
    }

    @Override
    public double measure() {
        // Simulate air quality measurement (range: 0 to 100, higher values indicate
        // better air quality)
        return Math.random() * 100;
    }
}

// Noise Level Sensor class
class NoiseLevelSensor extends BaseSensor {
    public NoiseLevelSensor(String sensorId) {
        super(sensorId);
    }

    @Override
    public double measure() {
        // Simulate noise level measurement (range: 0 to 100, higher values indicate
        // higher noise levels)
        return Math.random() * 100;
    }
}

// Base class for Systems
abstract class BaseSystem {
    private boolean enabled;

    public BaseSystem() {
        this.enabled = false;
    }

    public void enable() {
        enabled = true;
        System.out.println(getClass().getSimpleName() + " enabled.");
    }

    public void disable() {
        enabled = false;
        System.out.println(getClass().getSimpleName() + " disabled.");
    }

    public void displayStatus() {
        System.out.println(getClass().getSimpleName() + " Status: " + (enabled ? "Enabled" : "Disabled"));
    }
}

// Monitoring System class
class MonitoringSystem extends BaseSystem {
    private Map<String, Sensor> sensors;

    public MonitoringSystem() {
        this.sensors = new HashMap<>();
    }

    public void addSensor(String sensorId, Sensor sensor) {
        sensors.put(sensorId, sensor);
    }

    public void displayMeasurements() {
        System.out.println("Current Sensor Measurements:");
        for (Map.Entry<String, Sensor> entry : sensors.entrySet()) {
            String sensorId = entry.getKey();
            try {
                double measurement = entry.getValue().measure();
                System.out.println(sensorId + ": " + measurement);
            } catch (Exception e) {
                System.out.println(sensorId + ": Measurement failed. Reason: " + e.getMessage());
            }
        }
    }
}

// Smart Grid Class
class SmartGrid extends BaseSystem {
    private double renewableEnergyProduction;
    private double energyConsumption;

    public void integrateRenewableEnergy(double energyProduced) {
        renewableEnergyProduction += energyProduced;
        System.out.println("Renewable energy integrated: " + energyProduced + " units");
    }

    public void distributeEnergy(double energyConsumed) {
        energyConsumption += energyConsumed;
        System.out.println("Energy distributed: " + energyConsumed + " units");
    }

    public void displayGridStatus() {
        System.out.println("Smart Grid Status:");
        System.out.println("Renewable Energy Production: " + renewableEnergyProduction + " units");
        System.out.println("Energy Consumption: " + energyConsumption + " units");
    }
}

// Energy Consumption Monitoring Class
class EnergyConsumptionMonitor extends BaseSystem {
    private double currentEnergyConsumption;

    public void updateEnergyConsumption(double energyConsumed) {
        currentEnergyConsumption += energyConsumed;
        System.out.println("Energy Consumption Updated: " + energyConsumed + " units");
    }

    public double getCurrentEnergyConsumption() {
        return currentEnergyConsumption;
    }
}

// Public WiFi Class
class PublicWiFiSystem extends BaseSystem {
}

// Mobile App Class
class MobileApp {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    public void accessServices() {
        System.out.println(appName + " accessed city services.");
    }

    public void reportIssues() {
        System.out.println(appName + " reported an issue.");
    }

    public void receiveAlerts() {
        System.out.println(appName + " received an alert.");
    }
}

// Digital Signage Class
class DigitalSignage {
    public void displayInformation(String message) {
        System.out.println("Digital Signage: " + message);
    }
}

// Big Data Analytics Class
class BigDataAnalytics {
    public void analyzeData(String dataset) {
        System.out.println("Analyzing Big Data: " + dataset);
    }
}

// Predictive Analytics Class
class PredictiveAnalytics {
    public void forecastTrends(String trend) {
        System.out.println("Forecasting Trends: " + trend);
    }
}

// User class representing citizens
class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

// E-Government Services Platform
class EGovernmentServices {
    private List<String> availableServices;

    public EGovernmentServices() {
        this.availableServices = new ArrayList<>();
        // Adding some sample government services
        availableServices.add("Pay Taxes");
        availableServices.add("Renew Driver's License");
        availableServices.add("Apply for Building Permits");
    }

    public void displayAvailableServices() {
        System.out.println("Available Government Services:");
        for (String service : availableServices) {
            System.out.println("- " + service);
        }
    }

    public void processServiceRequest(User user, String service) {
        System.out.println(user.getUsername() + " requested service: " + service);
        // Implement service processing logic here
        System.out.println("Service request processed successfully.");
    }
}

// Community Engagement Platform
class CommunityEngagementPlatform {
    private List<String> feedback;
    private List<String> reportedIssues;

    public CommunityEngagementPlatform() {
        this.feedback = new ArrayList<>();
        this.reportedIssues = new ArrayList<>();
    }

    public void collectFeedback(User user, String userFeedback) {
        feedback.add(user.getUsername() + ": " + userFeedback);
        System.out.println("Feedback collected from " + user.getUsername() + ": " +
                userFeedback);
    }

    public void reportIssue(User user, String issue) {
        reportedIssues.add(user.getUsername() + ": " + issue);
        System.out.println("Issue reported by " + user.getUsername() + ": " + issue);
    }

    public void displayFeedbackAndIssues() {
        System.out.println("Feedback and Reported Issues:");
        for (String fb : feedback) {
            System.out.println("Feedback: " + fb);
        }
        for (String issue : reportedIssues) {
            System.out.println("Reported Issue: " + issue);
        }
    }
}

// Patient class representing individuals seeking healthcare services
class Patient {
    private String patientId;
    private String name;

    public Patient(String patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }
}
public class SmartCityMain {
    public static void main(String[] args) {

        try {
            MonitoringSystem monitoringSystem = new MonitoringSystem();
            AirQualitySensor airQualitySensor = new AirQualitySensor("AirQualitySensor");
            NoiseLevelSensor noiseLevelSensor = new NoiseLevelSensor("NoiseLevelSensor");
            monitoringSystem.addSensor(airQualitySensor.getSensorId(), airQualitySensor);
            monitoringSystem.addSensor(noiseLevelSensor.getSensorId(), noiseLevelSensor);
            monitoringSystem.enable();
            monitoringSystem.displayMeasurements();
            monitoringSystem.disable();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        // Smart Grid
        SmartGrid smartGrid = new SmartGrid();
        smartGrid.enable();
        smartGrid.integrateRenewableEnergy(50);
        smartGrid.distributeEnergy(30);
        smartGrid.displayStatus();
        smartGrid.disable();

        // Energy Consumption Monitor
        EnergyConsumptionMonitor energyConsumptionMonitor = new EnergyConsumptionMonitor();
        energyConsumptionMonitor.enable();
        energyConsumptionMonitor.updateEnergyConsumption(25);
        System.out.println("Current Energy Consumption: " +
                energyConsumptionMonitor.getCurrentEnergyConsumption() + " units");
        energyConsumptionMonitor.disable();

        // Public WiFi System
        PublicWiFiSystem publicWiFiSystem = new PublicWiFiSystem();
        publicWiFiSystem.enable();
        publicWiFiSystem.displayStatus();
        publicWiFiSystem.disable();

        // Mobile App
        MobileApp mobileApp = new MobileApp("CityExplorer");
        mobileApp.accessServices();
        mobileApp.reportIssues();
        mobileApp.receiveAlerts();

        // Digital Signage
        DigitalSignage digitalSignage = new DigitalSignage();
        digitalSignage.displayInformation("Welcome to Smart City!");

        // Big Data Analytics
        BigDataAnalytics bigDataAnalytics = new BigDataAnalytics();
        bigDataAnalytics.analyzeData("Smart City Data");

        // Predictive Analytics
        PredictiveAnalytics predictiveAnalytics = new PredictiveAnalytics();
        predictiveAnalytics.forecastTrends("Future City Trends");

        // User
        User user = new User("JohnDoe");

        // E-Government Services
        EGovernmentServices eGovernmentServices = new EGovernmentServices();
        eGovernmentServices.displayAvailableServices();
        eGovernmentServices.processServiceRequest(user, "Pay Taxes");

        // Community Engagement Platform
        CommunityEngagementPlatform communityEngagementPlatform = new CommunityEngagementPlatform();
        communityEngagementPlatform.collectFeedback(user, "Great city services!");
        communityEngagementPlatform.reportIssue(user, "Pothole on Main Street");
        communityEngagementPlatform.displayFeedbackAndIssues();

        // Patient
        Patient patient = new Patient("P001", "Alice");

        // Smart Building
        SmartBuilding smartBuilding = new SmartBuilding();
        smartBuilding.turnOnLights();
        smartBuilding.turnOnClimateControl();
        smartBuilding.armSecuritySystem();
        smartBuilding.displayBuildingStatus();
    }
}


       