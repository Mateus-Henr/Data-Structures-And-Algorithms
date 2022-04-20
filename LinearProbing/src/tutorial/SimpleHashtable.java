package tutorial;

public class SimpleHashtable
{
    private StoredEmployee[] hashtable;

    public SimpleHashtable()
    {
        this.hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee)
    {
        int hashedKey = hashKey(key);

        // This implementation wraps if we get to the end of the array.
        if (occupied(hashedKey))
        {
            // This will identify where we need to stop when we wrap.
            int stopIndex = hashedKey;

            if (hashedKey == hashtable.length - 1)
            {
                hashedKey = 0;
            }
            else
            {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex)
            {
                // This code handles wrapping as well.
                // hashKey = 8 -> (8 + 1) % 10 = 9.
                // hashKey = 9 -> (9 + 1) % 10 = 0.
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        // This condition will only be true, even after wrapping no position was found.
        // This is redundant since the same checking is done above , but it's constant time.
        if (occupied(hashedKey))
        {
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        }
        else
        {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee remove(String key)
    {
        int foundKey = hashKey(key);

        if (foundKey == -1)
        {
            return null;
        }

        Employee removedEmployee = hashtable[foundKey].employee;

        hashtable[foundKey] = null;

        return removedEmployee;
    }

    public Employee get(String key)
    {
        int foundKey = findKey(key);

        if (foundKey == -1)
        {
            return null;
        }

        return hashtable[foundKey].employee;
    }

    private int findKey(String key)
    {
        int hashedKey = hashKey(key);

        if ((hashtable[hashedKey] != null) && (hashtable[hashedKey].key.equals(key)))
        {
            return hashedKey;
        }

        int stopIndex = hashedKey;

        if (hashedKey == hashtable.length - 1)
        {
            hashedKey = 0;
        }
        else
        {
            hashedKey++;
        }

        while ((hashedKey != stopIndex) && (hashtable[hashedKey] != null) && (!hashtable[hashedKey].key.equals(key)))
        {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        return ((hashtable[hashedKey] != null) && (hashtable[hashedKey].key.equals(key))) ? hashedKey : -1;
    }

    private int hashKey(String key)
    {
        return key.length() % hashtable.length;
    }

    private boolean occupied(int index)
    {
        return hashtable[index] != null;
    }

    public void printHashtable()
    {
        for (int i = 0; i < hashtable.length; i++)
        {
            if (hashtable[i] == null)
            {
                System.out.println("empty");
            }
            else
            {
                System.out.println("Position " + i + ": " + hashtable[i].employee);
            }
        }
    }

}