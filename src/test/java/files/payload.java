package files;

public class payload {
	
	public static String AddPlace() {
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String complexJson() {
		return "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 4070,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 60\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Java\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"QTP\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"TestCafe\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}
	
	public static String AddBook(String isbn, String aisle) {
		String payload = "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java Advanced\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John T\"\r\n"
				+ "}\r\n"
				+ "";
		return payload;
	}

	public static String SRPayload() {
		String payload ="{\r\n"
				+ "    \"sendMeCopy\": false,\r\n"
				+ "    \"index\": \"2\",\r\n"
				+ "    \"positionName\": \"Java Developer_Pradeep2\",\r\n"
				+ "    \"quantity\": 1,\r\n"
				+ "    \"selectedPositionName\": \"Java Developer\",\r\n"
				+ "    \"remainingQuantity\": 1,\r\n"
				+ "    \"positionRoleId\": 1,\r\n"
				+ "    \"positionSeniorityId\": 1,\r\n"
				+ "    \"positionSeniorityName\": \"Trainee\",\r\n"
				+ "    \"travelPeriodType\": \"DAYS\",\r\n"
				+ "    \"locationOffshore\": true,\r\n"
				+ "    \"travelPeriodLength\": 0,\r\n"
				+ "    \"load\": 100,\r\n"
				+ "    \"locationId\": 13901240,\r\n"
				+ "    \"clientId\": 81164898,\r\n"
				+ "    \"clientBU\": \"Hobbiton\",\r\n"
				+ "    \"sowId\": 81165042,\r\n"
				+ "    \"projectId\": 81165037,\r\n"
				+ "    \"projectStudioName\": \"Digital Experience Platforms\",\r\n"
				+ "    \"positionType\": \"Confirmed\",\r\n"
				+ "    \"clientInterviewRequired\": false,\r\n"
				+ "    \"englishRequired\": true,\r\n"
				+ "    \"opening\": true,\r\n"
				+ "    \"replacement\": false,\r\n"
				+ "    \"positionNeedDTOList\": [\r\n"
				+ "        {\r\n"
				+ "            \"alberthaId\": 4016,\r\n"
				+ "            \"competencyId\": null,\r\n"
				+ "            \"competencyName\": \"Fast Learner\",\r\n"
				+ "            \"importance\": \"REQUIRED\",\r\n"
				+ "            \"evidenceValue\": 5\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"alberthaId\": 1595,\r\n"
				+ "            \"competencyId\": null,\r\n"
				+ "            \"competencyName\": \"english\",\r\n"
				+ "            \"importance\": \"CRITICAL\",\r\n"
				+ "            \"evidenceValue\": 5\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"alberthaId\": 4018,\r\n"
				+ "            \"competencyId\": null,\r\n"
				+ "            \"competencyName\": \"Clear Thinker\",\r\n"
				+ "            \"importance\": \"CRITICAL\",\r\n"
				+ "            \"evidenceValue\": 5\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"alberthaId\": 2778,\r\n"
				+ "            \"competencyId\": null,\r\n"
				+ "            \"competencyName\": \"unit testing\",\r\n"
				+ "            \"importance\": \"REQUIRED\",\r\n"
				+ "            \"evidenceValue\": 5\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"alberthaId\": 9085,\r\n"
				+ "            \"competencyId\": null,\r\n"
				+ "            \"competencyName\": \"Creativity & Innovation\",\r\n"
				+ "            \"importance\": \"REQUIRED\",\r\n"
				+ "            \"evidenceValue\": 5\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"alberthaId\": 2823,\r\n"
				+ "            \"competencyId\": null,\r\n"
				+ "            \"competencyName\": \"leadership skills\",\r\n"
				+ "            \"importance\": \"REQUIRED\",\r\n"
				+ "            \"evidenceValue\": 5\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"alberthaId\": 1626,\r\n"
				+ "            \"competencyId\": null,\r\n"
				+ "            \"competencyName\": \"java\",\r\n"
				+ "            \"importance\": \"REQUIRED\",\r\n"
				+ "            \"evidenceValue\": 5\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"startDate\": \"17-02-2022\",\r\n"
				+ "    \"endDate\": \"17-02-2023\",\r\n"
				+ "    \"positionTypeName\": \"Confirmed\",\r\n"
				+ "    \"studioId\": \"5288205\",\r\n"
				+ "    \"sfdcFlow\": false,\r\n"
				+ "    \"sfdcOpeningId\": 15809,\r\n"
				+ "    \"openingId\": \"@MAN-81164898-12093\",\r\n"
				+ "    \"opportunityId\": \"@MAN-81164898-12093\",\r\n"
				+ "    \"newSrFlow\": true,\r\n"
				+ "    \"validateAll\": true\r\n"
				+ "}";
		return payload;
	}

}
