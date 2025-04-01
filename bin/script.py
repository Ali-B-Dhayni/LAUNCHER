#with open('C:\\Launcher\\excel\\output.txt', 'w') as file:
#    file.write("the test run successfully motherfunckersssss")

import serial 
import time

try:
	ser = serial.Serial("COM3", 9600)
	time.sleep(2)
	with open("C:\\Launcher\\excel\\output.csv", "w") as file:
		while True:
			try:
				line = ser.readline().decode().strip()
				file.write(line + "\n")
				print(line)
			except serial.SerialException:
				print("Arduino disconnected")
				break
except serial.SerialException:
	print("Unable to connect to Arduino")

