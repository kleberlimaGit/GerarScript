package Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

import scripts.DesiredOrder;

public class Application {

	public static void main(String[] args) {
		String path = "C:\\Users\\Kleber\\Documents\\categorias.txt";
		FileReader fr = null;
		BufferedReader br = null;
		Locale.setDefault(new Locale("en", "US"));
		try{
			fr =  new FileReader(path);
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			while(line != null){
				DesiredOrder des = new DesiredOrder();
				String name = line.split(";")[0];
				String img = line.split(";")[1];
				Double perceivedValue = Double.valueOf(line.split(";")[2]);
				Double toleranceOnFreight = Double.valueOf(line.split(";")[3]);
				Double weight = Double.valueOf(line.split(";")[4].replace(",", "."));
				Double width = Double.valueOf(line.split(";")[5]);
				int transportTypeId = Integer.valueOf(line.split(";")[6]);
				int subcategoryId = Integer.valueOf(line.split(";")[8]);
				des.setImageUri(img);
				des.setName(name.toUpperCase());
				des.setSubCategoryId(subcategoryId);
				des.setPerceivedValue(perceivedValue);
				des.setToleranceOnFreight(toleranceOnFreight);
				des.setTransportTypeId(transportTypeId);
				des.setWeight(weight);
				des.setWidth(width);
				System.out.printf("INSERT INTO desired_order (depth, height, helper, image_uri, margin_on_freight, name, perceived_value, tolerance_on_freight, uuid, volume, weight, width, sub_category_id, transport_type_id) VALUES"
						+ " (10, 10, 0, '%s', 20, '%s', %.2f, %.2f, '%s', 0.1, %.2f, %.2f, %d, %d);", name,img,perceivedValue,toleranceOnFreight,des.getUuid(),weight,width,subcategoryId,transportTypeId);

				System.out.println();
				line = br.readLine();
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}

	}

	}

}
