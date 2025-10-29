// SmartHomeLighting.java

@FunctionalInterface
interface LightAction {
    void execute();
}

class SmartLight {
    private String name;

    public SmartLight(String name) {
        this.name = name;
    }

    public void activate(LightAction action) {
        System.out.print("[" + name + "] ");
        action.execute();
    }
}

public class smartHomeLighting {
    public static void main(String[] args) {
        SmartLight hallwayLight = new SmartLight("Hallway Light");
        SmartLight bedroomLight = new SmartLight("Bedroom Light");
        SmartLight livingRoomLight = new SmartLight("Living Room Light");

        // Lambda for motion trigger
        LightAction motionDetected = () -> System.out.println("Motion detected: Turning on to 100% brightness.");

        // Lambda for time of day (evening)
        LightAction eveningTime = () -> System.out.println("Evening time: Setting warm dim light.");

        // Lambda for voice command
        LightAction voiceCommand = () -> System.out.println("Voice command received: Turning off the light.");

        // Lambda for party mode
        LightAction partyMode = () -> System.out.println("Party mode: Activating color cycle pattern.");

        // Simulate triggers
        hallwayLight.activate(motionDetected);
        bedroomLight.activate(eveningTime);
        hallwayLight.activate(voiceCommand);
        livingRoomLight.activate(partyMode);
    }
}