class MyBirthday{
    private int year, month, day;

    //constructor
    MyBirthday(int x, int y, int z){
        year = x;
        month = y;
        day = z;
    }
    //isLeapYear
    public boolean isLeapYear() {
        if (year%400 == 0) {
            return true;
        }else if (year%100 == 0) {
            return false ;
        }else if (year%4 == 0) {
            return true;
        }else {
            return false;
        }
    }

    //check the day if it is valid
    public boolean checkValidValue(){
        if(isLeapYear() && month == 2 && day > 29){
            return false;
        }else if(!isLeapYear() && month == 2 && day > 28){
            return false;
        }else if (month == 4 || month == 6 || month == 9 || month == 11){
            if(day > 30){
                return false;
            }else{
                return true;
            }
        }else if (day > 31 || month > 12 || year < 0 || month < 1 || day < 1){
            return false;
        }
        return true;
    }

    //towareki
    public String toWareki(){
        if (year == 2019 && month == 5 && day == 1 || year == 2019 && month >5 || year > 2019 || year ==2019 && month == 5 && day > 1 ){
            return "REIWA" + (year - 2019 +1); 
        }else if (year > 1989 && year < 2019 || year == 1989 && month > 1 || year == 1989 && month == 1 && day >=8 || year == 2019 && month < 4 || year == 2019 && month == 4 && day <= 30 ) {
            return "HEISEI" + (year - 1989 + 1);
        }else if (year > 1926 && year < 1989 || year == 1989 && month == 12 && day >=25 || year == 1989 && month == 1 && day <= 7){
            return "SHOWA" + (year -1926 + 1);
        }else if (year >1912 && year < 1926 || year == 1912 && month > 7 || year == 1912 && month == 7 && day >=30 || year == 1926 && month < 12 || year == 1926 && month == 12 && day <= 24){
            return "TAISHO" + (year -1912 + 1);
        }else{
            return "MEIJI" + (year -1868 +1);
        }
    }

    //getdayofweek
    public String getDayOfWeek(){
        String dow = "";
        int h,C,Y,r,y,m;
        if(month == 1 || month == 2){
            m = month +12;
            y = year -1;
        }else {
            m = month;
            y = year;
        }
        Y = y%100;
        C = y/100;
        r = -2*C + C/4;
        h = (day + 26*(m + 1)/10 + Y + Y/4 + r)%7;
        switch (h){
            case 1:
                dow = "SUN";
                break;
            case 2:
                dow = "MON";
                break;
            case 3:
                dow = "TUE";
                break;
            case 4:
                dow = "WED";
                break;
            case 5:
                dow = "THU";
                break;
            case 6:
                dow = "FRI";
                break;
            case 0:
                dow = "SAT";
                break;
            default:
                System.out.println("ERROR!!!"); 
        }
        return dow;
    } 
}