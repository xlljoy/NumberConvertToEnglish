package com.xlljoy.o2o.service;

import com.xlljoy.o2o.dto.DemoExecution;
import com.xlljoy.o2o.enums.ConversionResultEnum;

public class DemoConversion{
	private String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    private String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public DemoExecution getEnglishWord(int num) {
    	// check if it is 0, return.
        if (num == 0) {
        	DemoExecution conversionExecution = new DemoExecution(ConversionResultEnum.SUCCESS);
            conversionExecution.setEnglishResult("Zero");
            return conversionExecution;
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num > 0) {

            if (num % 1000 != 0) {
                StringBuilder tmp = new StringBuilder();

                // Group the number by thousands (3 digits)
                convertHelper(num % 1000, tmp);
                tmp.append(THOUSANDS[index]).append(" ");
                sb.insert(0, tmp);

            }

            index++;
            num /= 1000;

        }
        // record state and value to DemoExecution
        DemoExecution conversionExecution = new DemoExecution(ConversionResultEnum.SUCCESS);
        conversionExecution.setEnglishResult(sb.toString().trim());
        return conversionExecution;
    }

    private void convertHelper(int num, StringBuilder sb) {

        if (num == 0) {
            return;
        }
        else if (num < 20) {
            sb.append(LESS_THAN_TWENTY[num]).append(" ");
            return;
        }
        else if (num < 100) {
            sb.append(TENS[num / 10]).append(" ");
            convertHelper(num % 10, sb);
        }
        else {
            sb.append(LESS_THAN_TWENTY[num / 100]).append(" Hundred ");
            convertHelper(num % 100, sb);
        }
    }


}
