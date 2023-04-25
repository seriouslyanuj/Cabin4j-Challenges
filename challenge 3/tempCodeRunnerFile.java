suggestions for prefix \"" + prefix + "\":");
            for (String suggestion : suggestions) {
                System.out.println(suggestion + " (" + weights.get(suggestion) + ")");
            }

            System.out.println();