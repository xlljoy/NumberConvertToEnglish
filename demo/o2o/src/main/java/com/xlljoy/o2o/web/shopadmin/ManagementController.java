package com.xlljoy.o2o.web.shopadmin;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xlljoy.o2o.dto.DemoExecution;
import com.xlljoy.o2o.enums.ConversionResultEnum;
import com.xlljoy.o2o.service.DemoConversion;

@Controller
@RequestMapping("/admin")
public class ManagementController {
	
	@RequestMapping(value="/numberconvert", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> getNumberConvetted(@RequestParam(value = "number") String numberInput) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int number = Integer.MIN_VALUE;
        int originalNumber = number;
        // return failure if input is out of range
        if (numberInput.length() > Integer.toString(Integer.MAX_VALUE).length()) {
    		modelMap.put("success", false);
    		modelMap.put("errMsg", String.format("please input number within the range of [%s, %s]", Integer.MIN_VALUE, Integer.MAX_VALUE));
    		return modelMap;
        }

        StringBuilder result = new StringBuilder();
        // parse number
        try {
            number = Integer.parseInt(numberInput);
            originalNumber = number;
            // check if the number is negative number
            if (number < 0) {
                result.append("Minus ");
            }
            number = Math.abs(number);
        } catch (Exception e) {
        	// return, if it failed to parse, illegal inputs
        	
    		modelMap.put("success", false);
    		modelMap.put("errMsg", "please input number");
    		e.printStackTrace();
    		return modelMap;
        }
        DemoConversion service = new DemoConversion();
        // do the translation
		DemoExecution de = service.getEnglishWord(number);
        
		// check the translate result
		if (de.getState() == ConversionResultEnum.SUCCESS.getState()) {
			result.append(de.getEnglishResult());
			modelMap.put("English", result);
			modelMap.put("success", true);
			return modelMap;
		}
		modelMap.put("success", false);
		modelMap.put("errMsg", de.getStateInfo());
		return modelMap;
	}

}
