#include "max6675.h"

// Define the Arduino pins, the MAX6675 module is connected to
int SO_PIN1 = 4;  // Serail Out (SO) pin 3
int CS_PIN1 = 5;  // Chip Select (CS) pin 4 
int SCK_PIN1 = 6; // Clock (SCK) pin 5

int SO_PIN2 = 3;  // Serail Out (SO) pin 3
int CS_PIN2 = 7;  // Chip Select (CS) pin 4
int SCK_PIN2 = 8; // Clock (SCK) pin 5

int SO_PIN3 = 2;  // Serail Out (SO) pin 3
int CS_PIN3 = 9;  // Chip Select (CS) pin 4
int SCK_PIN3 = 10; // Clock (SCK) pin 5

float x = 0;
// Create an instance of the MAX6675 class with the specified pins
MAX6675 thermocouple1(SCK_PIN1, CS_PIN1, SO_PIN1);
MAX6675 thermocouple2(SCK_PIN2, CS_PIN2, SO_PIN2);
MAX6675 thermocouple3(SCK_PIN3, CS_PIN3, SO_PIN3);

void setup() {
  Serial.begin(9600);
  Serial.print("Time(m),Thermo1, Thermo2, Thermo3");
  Serial.print("\n");
  delay(500);
}

void loop() {
  Serial.print(x/60.0);
  Serial.print(",");
  Serial.print(thermocouple1.readCelsius());
  Serial.print(",");
  Serial.print(thermocouple2.readCelsius());
  Serial.print(",");
  if(x%5==0)
    Serial.print(thermocouple3.readCelsius());
  Serial.print("\n");
  
  x += 1;
  delay(1000);
}