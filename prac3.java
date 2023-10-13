public class prac3 {
    
    private boolean putUserInParam(User user, Condition cond){

        //유저 정보가 들어있는 User의 정보를 임시의 파라미터에 넣는다
        //예를 들어 nickname은 null이 가능하다
        Object[][] tempParams = new Object[5][2];
        tempParams[0][0] = "id";
        tempParams[0][1] = user.id;
        tempParams[1][0] = "pwd";
        tempParams[1][1] = user.pwd;
        tempParams[2][0] = "name";
        tempParams[2][1] = user.name;
        tempParams[3][0] = "nickname";
        tempParams[3][1] = user.nickname;
        tempParams[4][0] = "sex";
        tempParams[4][1] = user.sex;

        //tempParams의 값이 null이 아닌것의 갯수를 체크한다
        int indicator = 0;
        for (int i = 0; i < tempParams.length; i++) {
            if (tempParams[i][0] != null) {
                indicator++;
            }    
        }

        //유저가 신규인지 기존인지 확인하는 Condition의 값에 따라
        //새로만들 파라미터의 길이가 변한다
        int index = 0;
        Object[][] params = null;
        if (cond.info == "new") {
            params = new Object[indicator + 1][2];
        } else {
            params = new Object[indicator + 3][2];
        }

        //tempParams의 null이 아닌 배열만 골라서 params에 넣는다
        for (int i = 0; i < tempParams.length; i++) {
            if (tempParams[i][0] != null) {
                params[index][0] = tempParams[i][0];
                params[index][1] = tempParams[i][1];
                index++;
            }    
        }

        return true;
    }

}

