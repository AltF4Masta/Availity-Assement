package main.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CSVSorter {
	final static String SPLIT_BY = ",";

	Map<String, UserEntity> userMap = new HashMap<String, UserEntity>();

	public void extractor(String fileLocation) {
		BufferedReader br = null;
		String line = "";
		try {
			FileReader reader = new FileReader(fileLocation);
			br = new BufferedReader(reader);
			while ((line = br.readLine()) != null) {
				String[] userInfo = line.split(SPLIT_BY);

				UserEntity user = new UserEntity(userInfo[0], userInfo[1], Integer.parseInt(userInfo[2]), userInfo[3]);

				if (userMap.containsKey(user.getUserId())) {
					if (user.getVersion() > userMap.get(user.getUserId()).getVersion()) {
						userMap.put(user.getUserId(), user);
					}
				} else {
					userMap.put(user.getUserId(), user);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		while (!userMap.isEmpty()) {
			List<UserEntity> userArray = new ArrayList<UserEntity>();
			Iterator<Map.Entry<String, UserEntity>> itr = userMap.entrySet().iterator();
			Map.Entry<String, UserEntity> entry = itr.next();
			UserEntity tempUser = entry.getValue();
			userArray.add(tempUser);
			itr.remove();

			while (itr.hasNext()) {
				entry = itr.next();
				if (entry.getValue().getInsuraceCompany().contentEquals(tempUser.getInsuraceCompany())) {
					userArray.add(entry.getValue());
					itr.remove();
				}
			}
			Collections.sort(userArray);
			writeToFile(tempUser, userArray);
		}
	}

	private void writeToFile(UserEntity user, List<UserEntity> userArray) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					"src/main/resources/" + user.getInsuraceCompany() + ".csv"));
			for (UserEntity entity : userArray) {
				writer.write(entity.toString() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
