switch(c) {
            case '#':
                throw new HashException();
            case ' ': sb.append(" ");
                break;
            case '1': sb.append("One");
                break;
            case '2': sb.append("Two");
                break;
            case '3': sb.append("Three");
                break;
            case '4': sb.append("Four");
                break;                
            case '5': sb.append("Five");
                break; 
            case '6': sb.append("Six");
                break;
            case '7': sb.append("Seven");
                break;
            case '8': sb.append("Eight");
                break;     
            case '9': sb.append("Nine");
                break; 
            case '0': sb.append("Zero");
                break;
            default:  sb.append(Integer.toString(c));
                break;
        }